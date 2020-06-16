package com.project.controller;

import com.project.dto.User;
import com.project.repository.UserRep;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    /*@Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:/messages");
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(5);
        return messageSource;
    }*/

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("greeting", "Hello World");
        return "index";
    }


    @RequestMapping("/login")
    public String login(@RequestParam("name") String name, Model model) {
        User user = new User();
        user.setName(name);
        model.addAttribute("userclass", user);
        return "login";

    }

    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping("/profile")
    public String profile(String name, String surname, String password,
                          String email, Model model) {

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setEmail(email);

        userService.updateUser(user);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        System.out.println("Done in Profile");

        return "profile";
    }
}
