package com.pan.service;

import com.pan.model.User;

import java.util.List;

/**
 * Created by Pan on 2017/7/15.
 */
public interface IUserService {
    /**
     * 获取所有用户
     * @return
     */
    List<User> getUsers();
}
