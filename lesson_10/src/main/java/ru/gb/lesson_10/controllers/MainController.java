package ru.gb.lesson_10.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/onlyYou")
    @ResponseBody
    public String pageOnlyForAdmins() {
        return "admin-only-page";
    }

}
