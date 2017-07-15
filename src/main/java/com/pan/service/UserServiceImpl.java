package com.pan.service;

import com.pan.dao.IUserDao;
import com.pan.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pan on 2017/7/15.
 */
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iuserdao;

    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        users = iuserdao.getUsers();
        return users;
    }
}
