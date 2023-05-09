package com.example.tpcontacts.controller;

import com.example.tpcontacts.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
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


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String email, @RequestParam String password, HttpServletRequest request, Model model) {
        User user = userService.findByEmailAndPassword(email, password);
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

    @GetMapping("/edit")
    public String showEditForm(Model model, HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        if (email == null) {
            return "redirect:/login";
        }
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "edit-user";
    }

    @PostMapping("/edit")
    public String submitEditForm(@ModelAttribute("user") User user, HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        User currentUser = userService.getUserByEmail(email);
        user.setId(currentUser.getId());
        userService.save(user);
        return "redirect:/logout";
    }
    @GetMapping("/profile")
    public String showProfile(Model model, HttpServletRequest request) {
        String email = (String) request.getSession().getAttribute("email");
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }

}

