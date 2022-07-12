package com.eCommerceProject.api;

import com.eCommerceProject.request.UserNameUpdateRequest;
import com.eCommerceProject.request.UserUpdateNotificationPermissionRequest;
import com.eCommerceProject.service.UserService;
import com.eCommerceProject.dto.viewDto.UserViewDto;
import com.eCommerceProject.model.User;
import com.eCommerceProject.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody @Valid User userCreateDto) {
        this.userService.add(userCreateDto);
        return ResponseEntity.ok(new GenericResponse("User Created."));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getAll() {
       List<User> users = this.userService.getAll();
       return ResponseEntity.ok(users);
    }

    @GetMapping("getById/{id}")
    public User getByid(@PathVariable int id) {
        return this.userService.getByid(id);
    }

    @GetMapping("slice")
    public ResponseEntity<List<User>> slice(Pageable pageable) {
        List<User> users = this.userService.slice(pageable);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteById(int id) {
        this.userService.deleteById(id);
        return ResponseEntity.ok(new GenericResponse("User deleted..."));
    }

    @GetMapping("getDto")
    public ResponseEntity<List<UserViewDto>> getDto() {
        List<UserViewDto> users = this.userService.getUserViewDto();
        return ResponseEntity.ok(users);
    }

    @PutMapping("updateByUsername")
    public ResponseEntity<?> updateByUserName(@RequestBody UserNameUpdateRequest userNameUpdateRequest) {
        userService.updateByUserName(userNameUpdateRequest.getUserId(), userNameUpdateRequest.getUserName());
        return ResponseEntity.ok("success");
    }

    @PutMapping("updateUserNotificationPermission")
    public ResponseEntity<?> updateByNotificationPermission(UserUpdateNotificationPermissionRequest request) {
        userService.updateByNotificationPermission(request.getUserId(), request.isPermission());
        return ResponseEntity.ok("success");
    }
}
