package com.eCommerceProject.service.user;

import com.eCommerceProject.exception.NotFoundException;
import com.eCommerceProject.repository.UserRepository;
import com.eCommerceProject.dto.viewDto.UserViewDto;
import com.eCommerceProject.model.User;
import com.eCommerceProject.request.UserDeleteRequest;
import com.eCommerceProject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User add(User userCreateDto) {
         this.userRepository.save(new User(userCreateDto.getUserName(),
                userCreateDto.getPassword(), userCreateDto.getEMail(), userCreateDto.getUserCreateDate(), userCreateDto.isNotificationPermission()));
        return userCreateDto;
    }

    @Override
    public List<User> getAll() {
        final List<User> users = this.userRepository.findAll();
        return users;
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("user couldn't be found by following id: " + id));
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

    @Override
    public void updateByUserName(int userId, String userName) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            user.get().setUserName(userName);
            userRepository.save(user.get());
        }
    }

    @Override
    public void updateByNotificationPermission(int userId, boolean permission) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()) {
            user.get().setNotificationPermission(permission);
            userRepository.save(user.get());
        }

    }
}
