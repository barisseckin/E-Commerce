package com.eCommerceProject.business.concretes;

import com.eCommerceProject.business.abstracts.UserService;
import com.eCommerceProject.dataAccess.abstracts.UserDao;
import com.eCommerceProject.dto.createDto.UserCreateDto;
import com.eCommerceProject.dto.viewDto.UserViewDto;
import com.eCommerceProject.model.User;
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
    public void add(UserCreateDto userCreateDto) {
         this.userDao.save(new User(userCreateDto.getUserName(),
                userCreateDto.getPassword(), userCreateDto.getEMail()));
    }

    @Override
    public List<User> getAll() {
        final List<User> users = this.userDao.findAll();
        return users;
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

    @Override
    public List<UserViewDto> getUserViewDto() {
        final List<UserViewDto> users = this.userDao.findAll().stream().map(UserViewDto::of).collect(Collectors.toList());
        return users;
    }

}
