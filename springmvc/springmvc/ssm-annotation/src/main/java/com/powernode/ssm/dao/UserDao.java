package com.powernode.ssm.dao;

import com.powernode.ssm.bean.User;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName: UserDao
 * Description:
 * Datetime: 2024/4/1 17:03
 * Author: 老杜@动力节点
 * Version: 1.0
 */
public interface UserDao {

    @Select("select * from tbl_user where id = #{id}")
    User selectById(Long id);

}
