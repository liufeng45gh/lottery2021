package com.lucifer.mapper;

import com.lucifer.annotation.MapperScanSelf;
import com.lucifer.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MapperScanSelf
public interface QuestionMapper {

    List<Question> questionCmsSearchList(@Param("offset") Integer offset,@Param("count") Integer count,@Param(value = "title") String title);

    Integer questionCmsSearchCount(@Param(value = "title") String title);

    Integer insertQuestion(Question question);

    Question getQuestion(@Param(value = "id") Long id);

    Integer deleteQuestion(@Param(value = "id") Long id);

    Integer updateQuestion(Question question);

    Integer updateQuestionStatus(@Param(value = "id") Long id, @Param(value = "status") Integer status);

    List<Long> enableIdList();

    List<Long> enableRandomIdList( @Param(value = "count")  Integer count);
}
