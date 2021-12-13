package com.lucifer.controller.cms;

import com.lucifer.mapper.AnswerMapper;
import com.lucifer.mapper.QuestionMapper;

import com.lucifer.model.Answer;
import com.lucifer.model.Question;
import com.lucifer.service.QuestionService;
import com.lucifer.utils.PageUtil;
import com.lucifer.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CmsQuestionController {

    @Resource
    QuestionMapper questionMapper;

    @Resource
    AnswerMapper answerMapper;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    QuestionService questionService;

    @RequestMapping(value="/cms/question/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                       @RequestParam(value = "title",required = false) String title,
                       HttpServletRequest request){
        Integer perPageCount = 30;
        Integer offset = (page - 1) * perPageCount;
        List<Question> goodsList = questionMapper.questionCmsSearchList(offset,perPageCount,title);
        request.setAttribute("questionList",goodsList);

        Integer matchRecordCount=questionMapper.questionCmsSearchCount(title);
        Integer totalPageCount= PageUtil.getTotalPageCount(matchRecordCount, perPageCount);

        PageUtil pageUtil = new PageUtil(request);
        String pageDiv = pageUtil.willPaginate(totalPageCount,  "pages_bar",new String []{"page","msg"});
        request.setAttribute("pageDiv",pageDiv);
        request.setAttribute("title",title);


        return "/cms/question/list";
    }

    @RequestMapping(value="/cms/question/add",method = RequestMethod.GET)
    public String toAddUser(){
        return "/cms/question/addQuestion";
    }

    @RequestMapping(value="/cms/is-more/list.json",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List isMoreJsonList(HttpServletRequest request){
        List list = new ArrayList();
        Map hashMap = new HashMap<>();
        hashMap.put("id", 0);
        hashMap.put("parentId", -1);
        hashMap.put("terminal", true);
        hashMap.put("name", "单选");
        list.add(hashMap);
        return list;
    }

    @RequestMapping(value="/cms/question/add",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Result addUserSubmit(@RequestBody Question question){
        return questionService.addSubmit(question);
    }

    @RequestMapping(value="/cms/question/{id}/delete",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Result deleteSubmit(@PathVariable(value = "id") Long id){
        questionMapper.deleteQuestion(id);
        return Result.ok();
    }


    @RequestMapping(value="/cms/question/{id}/update",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Long id,HttpServletRequest request){
        Question question = questionMapper.getQuestion(id);
        List<Answer> answerList = answerMapper.answerListByQuestionId(question.getId());
        request.setAttribute("question",question);
        request.setAttribute("answerList",answerList);
        return "/cms/question/updateQuestion";
    }

    @RequestMapping(value="/cms/question/update",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Result updateSubmit(@RequestBody Question question){
      return questionService.updateSubmit(question);
    }

    @RequestMapping(value="/cms/question/update-status",method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public Result updateStatusSubmit(@RequestParam Long id, @RequestParam Integer status){
        questionMapper.updateQuestionStatus(id,status);
        return Result.ok();
    }

}
