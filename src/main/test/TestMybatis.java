import com.hzit.testMybatis.dao.impl.UserDaoImpl;
import com.hzit.testMybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMybatis {


    UserDaoImpl userDaoImpl;

    /**
     * 初始化，在执行 test方法之前，先执行这个
     */
    @Before
    public void setEnv(){
        String mybatisXml = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(mybatisXml);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            userDaoImpl = new UserDaoImpl(sqlSession);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //单元测试
    @Test
    public void testQueryUserInfoById(){

       User u = userDaoImpl.queryUserInfoById("1");

       System.out.println("u ="+ u.getName());

    }

    /**
     *
     */
    @Test
    public void testInsertUser(){

        User user = new User();
        user.setAge(38);
        user.setBirthday(new Date());
        user.setCreated(new Date());
        user.setId("3");
        user.setName("小翠");
        user.setPassword("123");
        user.setSex(0);
        user.setUpdated(new Date());
        user.setUserName("666");
        userDaoImpl.insertUser(user);
    }


    @Test
    public void testDel(){
        userDaoImpl.delById("1");
    }


    @Test
    public void testUpdate(){

        User user = new User();
        user.setAge(68);
        user.setName("小翠真厉害");
        user.setId("3");

        userDaoImpl.updateUser(user);
    }






//    public static void main(String[] args) {
//
//
//        try {
//            //读取mybatis 全局配置文件
//
//
//            //构建sqlSessionFactory
//
//
//            //
//            SqlSession sqlSession = sqlSessionFactory.openSession();
//
//            List<User>  list = sqlSession.selectList("user.queryAllUser");
//
//            System.out.println(list.get(0).getName());
//            System.out.println(list.get(0).getAge());
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }

}
