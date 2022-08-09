package com.eCommerceProject.service;

import com.eCommerceProject.repository.UserRepository;
import com.eCommerceProject.model.User;
import com.eCommerceProject.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    void add() {
        User user = new User();
        user.setUserName("Test-Name");
        user.setPassword("Test-Password");
        user.setEMail("test@gmail.com");

        when(userRepository.save(any(User.class))).thenReturn(user);
        User user1 = userService.add(user);

        assertEquals(user1.getEMail(), user.getEMail());
    }

    @Test
    void getAll() {
        User user = mock(User.class);
        user.setUserName("Test-Name");
        user.setPassword("Test-Password");
        user.setEMail("test@gmail.com");

        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        List<User> userList = userService.getAll();

        assertEquals(userList.size(), 1);
    }

    @Test
    void getByid() {
        int id = 1;
        userService.getByid(1);
        verify(userRepository).getById(id);
    }

    @Test
    void slice() {
    }

    @Test
    void deleteById() {
        int id = 1;
        userService.deleteById(id);
        verify(userRepository).deleteById(id);
    }

    @Test
    void getUserViewDto() {
        userService.getUserViewDto();
        verify(userRepository).findAll();
    }

    @Test
    void getByUserName() {
        String userName = "Test-Name";
        userService.getByUserName(userName);
        verify(userRepository).findByUserName(userName);
    }

    @Test
    void authDeleteByUser() {

    }
}