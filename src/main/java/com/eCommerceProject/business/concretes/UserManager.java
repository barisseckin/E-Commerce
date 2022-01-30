package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.UserService;
import com.eCommerceProject.dataAccess.abstracts.UserDao;
import com.eCommerceProject.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;

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
        final User user = this.userDao.getById(id);
        return user;
    }

    @Override
    public List<User> slice(Pageable pageable) {
        final List<User> users = this.userDao.findAll(pageable).stream().collect(Collectors.toList());
        return users;
    }

    @Override
    public void deleteById(int id) {
        this.userDao.deleteById(id);
    }

}
