package com.eCommerceProject.service;

import com.eCommerceProject.dto.viewDto.UserViewDto;
import com.eCommerceProject.model.User;
import com.eCommerceProject.request.UserDeleteRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User add(User createDto);
    List<User> getAll();
    User getByid(int id);
    List<User> slice(Pageable pageable);
    void deleteById(int id);
    List<UserViewDto> getUserViewDto();
    User getByUserName(String userName);
    void authDeleteByUser(UserDeleteRequest userDeleteRequest);
    User findByEMail(String eMail);
}