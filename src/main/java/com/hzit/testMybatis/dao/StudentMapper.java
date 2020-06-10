package com.hzit.testMybatis.dao;

import com.hzit.testMybatis.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    int deleteByPrimaryKey(Integer stuId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /**
     * 根据姓名和性别查
     * @param student
     * @return
     */
    Student queryByNameAndSex(Student student);

    Student queryByNameAndSex1(@Param("stuName") String name , @Param("stuSex") String sex);


    int countStudentNum();

    /**
     * 查询男性用户，如果输入了姓名，则按姓名查询
     * @return
     */
    public Student queryMStudent(@Param("name") String name);

    /**
     *
     * @param name
     * @param stuNo 学号
     * @return
     */
    public Student queryUserByNameorAge(@Param("name") String name ,@Param("stuNo") String stuNo);

    /**
     * 查询所有用户，如果输入了姓名按照姓
     * 名进行模糊查询，如果输入年龄，
     * 按照年龄进行查询，如果两者都输入
     * 两个条件都要成立。
     *
     * @param name
     * @param stuNo
     * @return
     */
    public List<Student> queryUserListByNameAndStuNo(@Param("name") String name ,@Param("stuNo") String stuNo);


    /**
     * 根据stuNo 修改姓名
     * @param name
     * @param stuNo
     * @return
     */
    public int updateStudentByStuId(@Param("name") String name ,@Param("stuNo") String stuNo);


    /**
     * 批量查询
     */
    public List<Student> queryByArray(@Param("stuNos") String [] stuNos);

    /**
     * 批量插入
     * @param studentList
     * @return
     */
    public int insertStudentList(@Param("studentList") List<Student> studentList);






}