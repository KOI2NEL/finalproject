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
        return new ResponseEntity<>(userResponses, HttpStatus.OK);

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<UserResponse> add(@RequestBody CreateUserDto createUserDto) {
        UserResponse userResponse = userService.addUser(createUserDto);

        if(userResponse != null){
            return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserResponse getById(@PathVariable("id") Long id) {
        return userService.findResponseById(id);
    }
}
