package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.api.MailSenderService;
import com.example.demo.service.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    private final UserService userService;
    private final MailSenderService mailSenderService;

    public CommonController(UserService userService, MailSenderService mailSenderService) {
        this.userService = userService;
        this.mailSenderService = mailSenderService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    @PostMapping("/user/create")
    public String createNewUser(@RequestParam(name = "user-name") String userName,
                                @RequestParam(name = "user-last-name") String userLastName) {
        userService.saveUser(new User(userName, userLastName));
        return "redirect:/";
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    @GetMapping("/home-2")
    public String getHomeSecondPage(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "index";
    }

    @PostMapping("/message/send")
    public String sendEmailMessage() {
        mailSenderService.sendEmail();
        return "redirect:/";
    }
}
