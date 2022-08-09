package com.eCommerceProject.service.user;

import com.eCommerceProject.dto.viewDto.UserViewDto;
import com.eCommerceProject.model.User;
import com.eCommerceProject.request.UserDeleteRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User add(User createDto);
    List<User> getAll();
    User getById(int id);
    List<User> slice(Pageable pageable);
    void deleteById(int id);
    List<UserViewDto> getUserViewDto();
    User getByUserName(String userName);
    void authDeleteByUser(UserDeleteRequest userDeleteRequest);
    User findByEMail(String eMail);
    void updateByUserName(int userId, String userName);
    void updateByNotificationPermission(int userId, boolean permission);
}
