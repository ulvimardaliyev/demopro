package com.project.controller;

import com.project.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @RequestMapping("/showForm")
    public String showForm() {

        return "showForm";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam("name") String name, Model model) {
        User user = new User();
        user.setName(name);
        model.addAttribute("name", user.getName());
        return "processForm";
    }
}
