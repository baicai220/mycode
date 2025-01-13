package com.powernode.spring6.test;

import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 动力节点
 * @version 1.0
 * @className SpringJdbcTest
 * @since 1.0
 **/
public class SpringJdbcTest {

    @Test
    public void testCallback(){
        // 如果你想写JDBC代码，可以使用callback回调函数。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // 准备SQL语句
        String sql = "select id, real_name, age from t_user where id = ?";
        // 注册回调函数，当execute方法执行的时候，回调函数中的doInPreparedStatement()会被调用。
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = null;
                ps.setInt(1, 2);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String realName = rs.getString("real_name");
                    int age = rs.getInt("age");
                    user = new User(id, realName, age);
                }
                return user;
            }
        });

        System.out.println(user);

    }

    @Test
    public void testBatchDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";
        // 准备数据
        Object[] objs1 = {12};
        Object[] objs2 = {13};
        Object[] objs3 = {14};
        Object[] objs4 = {15};
        // 添加到List集合
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);
        list.add(objs4);
        // 执行SQL语句
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testBatchUpdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ? , age = ? where id = ?";
        // 准备数据
        Object[] objs1 = {"小明1", 20, 12};
        Object[] objs2 = {"小明2", 21, 13};
        Object[] objs3 = {"小明3", 22, 14};
        Object[] objs4 = {"小明4", 23, 15};
        // 添加到List集合
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);
        list.add(objs4);
        // 执行SQL语句
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testBatchInsert(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into t_user(real_name, age) values(?,?)";

        // 准备数据
        Object[] objs1 = {"小花1", 30};
        Object[] objs2 = {"小花2", 31};
        Object[] objs3 = {"小花3", 32};
        Object[] objs4 = {"小花4", 33};

        // 添加到List集合
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);
        list.add(objs4);

        // 执行SQL语句
        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testQueryOneValue(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(1) from t_user"; // 返回总记录条数是一个整数数字。
        Long total = jdbcTemplate.queryForObject(sql, long.class);
        System.out.println("总记录条数：" + total);
    }

    @Test
    public void testQueryAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id,real_name,age from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(users);
    }

    @Test
    public void testQueryOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name,age from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void testDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";
        int count = jdbcTemplate.update(sql, 1);
        System.out.println(count);
    }

    @Test
    public void testUpdate(){
        // 根据id来修改某一条记录。
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ? , age = ? where id = ?";
        int count = jdbcTemplate.update(sql, "张三丰", 55, 1);
        System.out.println(count);
    }

    @Test
    public void testInsert(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // insert语句
        String sql = "insert into t_user(real_name, age) values(?,?)";
        // 注意：在JdbcTemplate当中，只要是insert delete update语句的，都是调用update方法。
        int count = jdbcTemplate.update(sql, "王五", 20);
        System.out.println(count);
    }

    @Test
    public void testJdbc(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }
}
