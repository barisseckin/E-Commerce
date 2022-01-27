package com.eCommerceProject.business.abstracts;

import com.eCommerceProject.entities.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAll();
    User getByid(int id);
}
