import com.hzit.testMybatis.dao.OrderMapper;
import com.hzit.testMybatis.dao.StudentMapper;
import com.hzit.testMybatis.dao.UserDao;
import com.hzit.testMybatis.dao.impl.UserDaoImpl;
import com.hzit.testMybatis.model.Orders;
import com.hzit.testMybatis.model.Student;
import com.hzit.testMybatis.model.User;
import com.hzit.testMybatis.model.UserOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMybatis {


    UserDaoImpl userDaoImpl;


    UserDao userDao;

    StudentMapper studentMapper;

    OrderMapper orderMapper;


    SqlSessionFactory sqlSessionFactory = null;

    SqlSession sqlSession = null;

    /**
     * 初始化，在执行 test方法之前，先执行这个
     */
    @Before
    public void setEnv(){
        String mybatisXml = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(mybatisXml);
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
             sqlSession = sqlSessionFactory.openSession();
//          userDaoImpl = new UserDaoImpl(sqlSession);

            //动态代理的方式
            userDao = sqlSession.getMapper(UserDao.class);

            studentMapper = sqlSession.getMapper(StudentMapper.class);

            orderMapper = sqlSession.getMapper(OrderMapper.class);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //单元测试
    @Test
    public void testQueryUserInfoById(){

//       User u = userDaoImpl.queryUserInfoById("2");

        User u =  userDao.queryUserInfoById("2");

       System.out.println("u ="+ u.getUserName());

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


    @Test
    public void testQueryStudentById() throws IOException {

        //第一次出现
        Student student = studentMapper.selectByPrimaryKey(7);
        System.out.println(student.getStuSex());

        //关闭sqlsession
        sqlSession.close();



        //第二次查询
        sqlSession = sqlSessionFactory.openSession();
        //动态代理的方式
        studentMapper = sqlSession.getMapper(StudentMapper.class);
        student = studentMapper.selectByPrimaryKey(7);
        System.out.println(student.getStuSex());



    }


    @Test
    public void testQueryByArray(){

        String [] stuNos = {"01","02","04"};

        List<Student>  studentList = studentMapper.queryByArray(stuNos);

    }


    @Test
    public void testQueryStudentByName(){

        Student s = new Student();
        s.setStuName("吴小娟");
        s.setStuSex("女");
        Student student = studentMapper.queryByNameAndSex(s);

        System.out.println(student.getStuSex());

        Student student1 = studentMapper.queryByNameAndSex1("吴小娟","女");

        System.out.println("=======" + student1.getStuSex());

        System.out.println(studentMapper.countStudentNum());

    }



    @Test
    public void testQueryMUser(){

        studentMapper.queryMStudent("宿舍");

    }


    @Test
    public void testQueryUserByNameorAge(){

        studentMapper.queryUserByNameorAge("周","1000");

    }

    @Test
    public void testQueryUserListByNameAndStuNo(){

        List<Student> studentList = studentMapper.queryUserListByNameAndStuNo("周",null);
        System.out.println("studentList 的大小："+ studentList.size());

    }

    @Test
    public void testUpdateStudentByStuId(){

        studentMapper.updateStudentByStuId("小翠","08");

    }


    /**
     * 批量插入
     */
    @Test
    public void testBatchInsert(){

        List<Student> studentList = new ArrayList<Student>();

        Student s = new Student();
        s.setStuSex("男");
        s.setStuName("小翠");
        s.setClaId(111);
        s.setStuBirth(new Date());
        s.setStuId(12);
        s.setOpeId(123);
        s.setStuPic(null);
        s.setStuNo("400");

        studentList.add(s);

        s = new Student();
        s.setStuSex("女");
        s.setStuName("小翠1号");
        s.setClaId(333);
        s.setStuBirth(new Date());
        s.setStuId(33);
        s.setOpeId(789);

        s.setStuPic(null);
        s.setStuNo("200");

        studentList.add(s);


        s = new Student();
        s.setStuSex("男");
        s.setStuName("小翠2号");
        s.setClaId(222);
        s.setStuBirth(new Date());
        s.setStuId(22);
        s.setOpeId(456);

        s.setStuPic(null);
        s.setStuNo("100");

        studentList.add(s);


        studentMapper.insertStudentList(studentList);

        sqlSession.commit();



    }


    /**
     * 懒加载
     * @param
     */
    @Test
    public void testLazyLoad(){

        Orders orders = orderMapper.queryOrderById(1);

        System.out.println("----------orders-" + orders.getUserId());

        //用UserOrder， mybatis 才回去加载
        UserOrder userOrder = orders.getUser();
//
        System.out.println("----------userOrder-" + userOrder.getUserName());


    }




    @Test
    public void testQueryByPk(){

        studentMapper.selectByPrimaryKey(7);
    }






    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = 3;

        if(a<b){
            System.out.println("-----------------");
        }else  if(b<c){
            System.out.println("=============");

        }else{
            System.out.println("-------3----------");

        }


    }

}
