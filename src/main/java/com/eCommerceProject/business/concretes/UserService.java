package com.eCommerceProject.business.concretes;

import com.eCommerceProject.dto.viewDto.UserViewDto;
import com.eCommerceProject.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void add(User createDto);
    List<User> getAll();
    User getByid(int id);
    List<User> slice(Pageable pageable);
    void deleteById(int id);
    List<UserViewDto> getUserViewDto();
    User getByUserName(String userName);
}
