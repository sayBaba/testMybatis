package com.hzit.testMybatis.dao;

import com.hzit.testMybatis.model.Student;
import com.hzit.testMybatis.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * dao层
 */
public interface UserDao {

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public User queryUserInfoById(String id);


    /**
     * 往数据数据添加数据
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 删除
     * @param id
     * @return
     */
    public int delById(String id);

    /**
     * 删除用户
     * @param user
     * @return
     */
    public int updateUser(User user);



}
