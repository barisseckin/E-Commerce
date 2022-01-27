package com.eCommerceProject.api.controller;

import com.eCommerceProject.business.abstracts.UserService;
import com.eCommerceProject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public void add(@RequestBody User user) {
        this.userService.add(user);
    }

    @GetMapping("getAll")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("getById/{id}")
    public User getByid(@PathVariable int id) {
        return this.userService.getByid(id);
    }

}
