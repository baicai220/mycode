package com.powernode.usermgt.dao;

import com.powernode.usermgt.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UserDao
 * Description:
 * Datetime: 2024/3/28 9:28
 * Author: 老杜@动力节点
 * Version: 1.0
 */
@Repository
public class UserDao {

    private static List<User> users = new ArrayList<>();

    static {
        // 类加载是初始化数据
        // 创建User对象
        User user1 = new User(1001L,"张三", 1, "zhangsan@powernode.com");
        User user2 = new User(1002L,"孙悟空", 1, "wukong@powernode.com");
        User user3 = new User(1003L,"猪八戒", 1, "bajie@powernode.com");
        User user4 = new User(1004L,"白骨精", 0, "bgj@powernode.com");
        User user5 = new User(1005L,"武松", 1, "ws@powernode.com");
        // 将User对象存储到List集合中
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
    }

    /**
     * 查询所有的用户信息
     * @return 用户列表List集合
     */
    public List<User> selectAll(){
        return users;
    }

    /**
     * 专门生成ID的。
     * @return
     */
    public Long generateId(){
        // 使用Stream API
        Long maxId = users.stream().map(user -> user.getId()).reduce((id1, id2) -> id1 > id2 ? id1 : id2).get();
        return maxId + 1;
    }

    /**
     * 保存用户信息
     * @param user
     */
    public void insert(User user){
        // 生成id
        Long id = generateId();
        // 给user对象id属性赋值
        user.setId(id);
        // 保存
        users.add(user);
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    public User selectById(Long id){
        // Stream API
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    /**
     * 修改用户信息
     * @param user
     */
    public void update(User user){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                return;
            }
        }
    }

    /**
     * 根据id删除用户
     * @param id
     */
    public void deleteById(Long id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return;
            }
        }
    }
}
