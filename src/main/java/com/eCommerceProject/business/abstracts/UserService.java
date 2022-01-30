package com.eCommerceProject.business.abstracts;

import com.eCommerceProject.dto.UserViewDto;
import com.eCommerceProject.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAll();
    User getByid(int id);
    List<User> slice(Pageable pageable);
    void deleteById(int id);
    List<UserViewDto> getUserViewDto();
}
