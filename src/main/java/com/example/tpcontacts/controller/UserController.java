package com.example.tpcontacts.controller;

import ch.qos.logback.core.model.Model;
import com.example.tpcontacts.repository.UserRepository;
import com.example.tpcontacts.repository.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/signup")
    public String signup(Map<String, Object> model) {
        User user = new User();
        model.put("user", user);
        return "signup";
    }
    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String password, HttpServletRequest request, Model model) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            request.getSession().setAttribute("email", email);
            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.getSession().invalidate();
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        if (email != null) {
            return "home";
        } else {
            return "redirect:/login";
        }
    }

}

