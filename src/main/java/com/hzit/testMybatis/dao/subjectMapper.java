package com.hzit.testMybatis.dao;

import com.hzit.testMybatis.model.subject;

public interface subjectMapper {
    int deleteByPrimaryKey(Integer subId);

    int insert(subject record);

    int insertSelective(subject record);

    subject selectByPrimaryKey(Integer subId);

    int updateByPrimaryKeySelective(subject record);

    int updateByPrimaryKey(subject record);
}