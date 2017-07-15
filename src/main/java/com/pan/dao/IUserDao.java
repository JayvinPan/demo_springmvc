package com.pan.dao;

import com.pan.model.User;

import java.util.List;

/**
 * Created by Pan on 2017/7/15.
 */
public interface IUserDao {

    /**
     * 获取所有用户
     * @return
     */
    List<User> getUsers();
}
