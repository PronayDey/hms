package com.hms.controller;

import java.util.List;

import com.hms.Service.UserService;
import com.hms.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView getUsers(Model model) {
        List<Users> users = userService.getAllUsers();

        model.addAttribute("users", users);
        ModelAndView view = new ModelAndView();
        view.setViewName("users");
        return view;
    }

}
