package com.codehero.bestshop.db.dao.interfaces;

import com.codehero.bestshop.db.entity.User;

//TODO concludere interfaccia
public interface UserDao {
    public boolean insertOrUpdateUser(User user);
    public Object [] retrieveUsernameAndPassword(String username, String password);
    public User retrieveUser(Integer id);
}
