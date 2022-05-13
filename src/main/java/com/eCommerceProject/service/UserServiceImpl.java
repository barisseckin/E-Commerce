package com.eCommerceProject.service;

import com.eCommerceProject.dataAccess.abstracts.UserRepository;
import com.eCommerceProject.dto.viewDto.UserViewDto;
import com.eCommerceProject.model.User;
import com.eCommerceProject.request.UserDeleteRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User add(User userCreateDto) {
         this.userRepository.save(new User(userCreateDto.getUserName(),
                userCreateDto.getPassword(), userCreateDto.getEMail(), userCreateDto.getUserCreateDate()));
        return userCreateDto;
    }

    @Override
    public List<User> getAll() {
        final List<User> users = this.userRepository.findAll();
        return users;
    }

    @Override
    public User getByid(int id) {
        final User user = this.userRepository.getById(id);
        return user;
    }

    @Override
    public List<User> slice(Pageable pageable) {
        final List<User> users = this.userRepository.findAll(pageable).stream().collect(Collectors.toList());
        return users;
    }

    @Override
    public void deleteById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<UserViewDto> getUserViewDto() {
        final List<UserViewDto> users = this.userRepository.findAll().stream().map(UserViewDto::of).collect(Collectors.toList());
        return users;
    }

   @Override
    public User getByUserName(String userName) {
        return userRepository.findByUserName(userName);
   }

    @Override
    public void authDeleteByUser(UserDeleteRequest userDeleteRequest) {
        User user = userRepository.findByEMail(userDeleteRequest.getEMail());
        userRepository.deleteById(user.getId());
    }

    @Override
    public User findByEMail(String eMail) {
        return userRepository.findByEMail(eMail);
    }
}
