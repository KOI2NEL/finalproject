package com.libraryapp.library.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> userResponses = userService.getAllUsers();
        if (userResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserResponse>>(userResponses, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpStatus add(@RequestBody CreateUserDto createUserDto) {
        userService.addUser(createUserDto);
        return HttpStatus.CREATED;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserResponse getById(@PathVariable("id") Long id) {
        return userService.findResponseById(id);
    }
}
