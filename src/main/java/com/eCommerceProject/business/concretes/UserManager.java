package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.UserService;
import com.eCommerceProject.dataAccess.abstracts.UserDao;
import com.eCommerceProject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        this.userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return this.userDao.findAll();
    }

    @Override
    public User getByid(int id) {
        return this.userDao.getById(id);
    }

}
