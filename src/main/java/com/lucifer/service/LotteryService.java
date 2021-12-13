package com.lucifer.service;

import com.lucifer.enumeration.Award;
import com.lucifer.exception.AwardException;
import com.lucifer.exception.NotLoginException;
import com.lucifer.mapper.AwardMapper;
import com.lucifer.model.AwardDayConfig;
import com.lucifer.model.MemberAward;
import com.lucifer.utils.Constant;
import com.lucifer.utils.DateUtils;
import com.lucifer.utils.Result;
import com.lucifer.utils.StringHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class LotteryService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    WxService wxService;


    @Resource
    AwardMapper awardMapper;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getMemberLotteryCountKey(Long memberId){
        String dayString = dateFormat.format(DateUtils.now());
        String key = Constant.CACHE_KEY_DAY_LOTTERY_COUNT_PRE + dayString + ":" + memberId;
        logger.info("getMemberLotteryCountKey is {}",key);
        return key;
    }

    public Long getMemberLotteryCount(Long memberId){
        String key = this.getMemberLotteryCountKey(memberId);
        String value = stringRedisTemplate.opsForValue().get(key);
        logger.info("getMemberLotteryCount value is {}",value);
        if (StringHelper.isEmpty(value)) {
            return 0l;
        }
        return Long.valueOf(value);

    }

    public Long incrementMemberLotteryCount(Long memberId){
        String key = this.getMemberLotteryCountKey(memberId);
        Long value = stringRedisTemplate.opsForValue().increment(key);
        logger.info("incrementMemberLotteryCount value is {}",value);
        return value;
    }

    public Result doLottery(String token) throws NotLoginException, AwardException {
        String userId = wxService.getIdByToken(token);
        if (StringHelper.isEmpty(userId)) {
            throw new NotLoginException("can not find user by token  : " + token);
        }

        Long memberId = Long.valueOf(userId);

        String dayString = dateFormat.format(DateUtils.now());
        String awardDay = awardMapper.getAwardDay(dayString);
        if (StringHelper.isEmpty(awardDay)) {
            throw  new AwardException(Constant.Not_Award_Day);
        }

        Long count = this.incrementMemberLotteryCount(memberId);
        if (count>3) {
            throw  new AwardException(Constant.Award_Times_Limit_Exceed);
        }

        List<AwardDayConfig> awardDayConfigList = awardMapper.getAwardDayConfigList(dayString);

        //计算1
        //AwardDayConfig config1 = this.getAwardDayConfig(awardDayConfigList,1);
        MemberAward memberAward = null;
        for (int i = 1; i<6 ;i++){
            memberAward = this.doLotteryByConfigId(awardDayConfigList,i,memberId,dayString);
            if(null != memberAward){
                break;
            }
        }


        return Result.ok(memberAward);
    }

    @Transactional
    public MemberAward doLotteryByConfigId( List<AwardDayConfig> awardDayConfigList,Integer configId,Long memberId,String day){
        Double rate = 0d;
        Integer totalCount = awardMapper.getAwardTotalCount(configId);
        if (null == totalCount) {
            logger.info("{} db total count is null",configId);
            totalCount = 0;
        }
        logger.info("{} total count is  - {}",configId,totalCount);
        Award award = Award.getById(configId);
        logger.info("{} Award config count is  - {}",award.id,award.totalCount);
        if (totalCount>=award.totalCount) {
            logger.info("{} config total award count is exceed",configId);
            return null;
        }
        rate = award.rate;
        logger.info("{} set rate  - {}",configId,rate);


        AwardDayConfig config = this.getAwardDayConfig(awardDayConfigList,configId);
        logger.info("{}-{} config is -{}",day,configId,config);
        if (null != config) {
            Integer count = awardMapper.getAwardDayCount(day,configId);
            logger.info("{} - {} count is  - {} ",day, configId, count);
            if (null != count) {
                if(count >=  config.getCount()){
                    logger.info("{} day award is exceed",configId);
                    return null;
                }
            }
            rate = config.getRate();
            logger.info("{} set rate  - {}",configId,config.getRate());
        }
        return doLotteryProcess(configId,memberId,rate,day);
    }

    public MemberAward doLotteryProcess(Integer configId, Long memberId,Double rate,String day){
        Double random = Math.random();
        logger.info(" random is {}",random);
        if (random < rate) {
            MemberAward memberAward = this.prizesMemberAward(configId,memberId,day);
            return memberAward;
        }
        return null;
    }

    public MemberAward prizesMemberAward(Integer configId, Long memberId,String day){
        MemberAward memberAward = new MemberAward();
        memberAward.setAwardId(configId);
        memberAward.setMemberId(memberId);
        awardMapper.insertMemberAward(memberAward);
        Integer totalDayCount = awardMapper.countAwardDayCount(day,configId);
        Integer updateCount = awardMapper.updateDayAwardCount(day,configId,totalDayCount);
        if (updateCount == 0) {
            awardMapper.insertDayAwardCount(day,configId,1);
        }
        Integer totalCount = awardMapper.countAwardTotalCount(configId);

        updateCount = awardMapper.updateTotalAwardCount(configId,totalCount);
        if (updateCount == 0){
            awardMapper.insertTotalAwardCount(configId,1);
        }

        return memberAward;
    }


    public AwardDayConfig getAwardDayConfig(List<AwardDayConfig> awardDayConfigList,Integer configId){
        for(AwardDayConfig config: awardDayConfigList) {
            if (configId.equals(config.getConfigId())) {
                return config;
            }
        }
        return null;
    }
}
