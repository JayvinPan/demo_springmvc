package com.pan.dao;

import com.pan.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pan on 2017/7/15.
 */
public class UserDaoImpl extends BaseDao implements IUserDao{

    /**
     * 获取所有用户
     * @return
     */
    @Autowired
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        String query = "select * from users";
        ResultSet rs = this.executeQuery(query, null);
        try {
            while (rs.next()) {
                users.add(new User(rs.getString("user_id"), rs.getString("password"),
                        rs.getString("nickname"), rs.getString("email")));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            this.close();
        }
        return users;
    }
}
