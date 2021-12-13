package com.lucifer.mapper;

import com.lucifer.annotation.MapperScanSelf;
import com.lucifer.model.AwardDayConfig;
import com.lucifer.model.Member;
import com.lucifer.model.MemberAward;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MapperScanSelf
public interface AwardMapper {
    List<MemberAward> getMemberAwardCount(@Param(value = "memberId") Long memberId);

    String getAwardDay(@Param(value = "id") String id);

    Integer insertAwardDay(@Param(value = "id") String id);

    Integer deleteAwardDay(@Param(value = "id") String id);

    List<String> getAwardDayList();

    List<AwardDayConfig> getAwardDayConfigList(@Param(value = "day") String day);

    List<AwardDayConfig> getAllAwardDayConfigList();

    Integer getAwardDayCount(@Param(value = "day") String day,@Param(value = "configId") Integer configId);

    Integer countAwardDayCount(@Param(value = "day") String day,@Param(value = "configId") Integer configId);

    Integer getAwardTotalCount(@Param(value = "configId") Integer configId);

    Integer countAwardTotalCount(@Param(value = "configId") Integer configId);

    Integer insertMemberAward(MemberAward memberAward);

    Integer updateDayAwardCount(@Param(value = "day") String day,@Param(value = "configId") Integer configId,@Param(value = "count")Integer count);

    Integer insertDayAwardCount(@Param(value = "day") String day,@Param(value = "configId") Integer configId,@Param(value = "count")Integer count);

    Integer updateTotalAwardCount(@Param(value = "configId") Integer configId,@Param(value = "count")Integer count);

    Integer insertTotalAwardCount(@Param(value = "configId") Integer configId,@Param(value = "count")Integer count);

    List<Member> rewardList(@Param(value = "awardId") Integer awardId);




}
