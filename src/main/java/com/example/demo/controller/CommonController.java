package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    private final UserService userService;

    public CommonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    //test
    @PostMapping("/user/create")
    public String createNewUser(@RequestParam(name = "user-name") String userName,
                                @RequestParam(name = "user-last-name") String userLastName) {
        userService.saveUser(new User(userName, userLastName));
        return "redirect:/";
    }
}
