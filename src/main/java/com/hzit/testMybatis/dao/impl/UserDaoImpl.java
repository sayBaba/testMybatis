package com.hzit.testMybatis.dao.impl;

import com.hzit.testMybatis.dao.UserDao;
import com.hzit.testMybatis.model.User;
import org.apache.ibatis.session.SqlSession;

public class UserDaoImpl implements UserDao {

     private SqlSession sqlSession;

     public UserDaoImpl(SqlSession sqlSession){
         this.sqlSession = sqlSession;
     }


    @Override
    public User queryUserInfoById(String id) {
        return sqlSession.selectOne("user.queryUserInfoById",id);
    }


    @Override
    public int insertUser(User user) {
        int rl = sqlSession.insert("user.insetUser",user);
        //提交
        sqlSession.commit();
        return rl;
    }

    @Override
    public int delById(String id) {

        sqlSession.delete("user.delUserById",id);

        sqlSession.commit();
        return 0;
    }

    @Override
    public int updateUser(User user) {
        sqlSession.update("user.updateUser",user);

        sqlSession.commit();

        return 0;
    }
}
