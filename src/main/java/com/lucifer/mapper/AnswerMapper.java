package com.lucifer.mapper;

import com.lucifer.annotation.MapperScanSelf;
import com.lucifer.model.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MapperScanSelf
public interface AnswerMapper {

    Integer insertAnswer(Answer answer);

    List<Answer> answerListByQuestionId(@Param("questionId") Long questionId);

    Integer deleteAnswersByQuestionId(@Param("questionId") Long questionId);
}
