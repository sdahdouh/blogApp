package blog.controllers;

import blog.models.User;
import blog.models.UserRole;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users/allusers")
    public String allUsers(Model model){
        List<User> allUsers = userService.findAll();
        model.addAttribute("allUsers", allUsers);
        return "users/allusers";
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        List<User> allUsers = userService.findAll();
        model.addAttribute("allUsers", allUsers);
        return "/login";
    }

    @GetMapping("users/register")
    public String register(Model model){
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "users/register";
    }

    @PostMapping("users/register")
    public String registerSumbit(@ModelAttribute User newUser){
        UserRole newRole = new UserRole("ROLE_USER",2L);
        newUser.setRole(newRole);
        newUser.setActivityPoints(50L);
        userService.create(newUser);
        return "/login";
    }



}
