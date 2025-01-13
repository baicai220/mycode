package cn.powernode.service;

import cn.powernode.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author 动力节点
 * @version 1.0
 * @className StudentService
 * @since 1.0
 **/
@Service("studentService")
public class StudentService {

    //@Resource(name = "studentDaoImplForMySQL")
    @Resource
    private StudentDao studentDao;

    // 不能出现在构造方法上。
    /*@Resource(name = "studentDaoImplForMySQL")
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    /*@Resource(name = "studentDaoImplForMySQL")
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/

    public void deleteStudent(){
        studentDao.deleteById();
    }

}
