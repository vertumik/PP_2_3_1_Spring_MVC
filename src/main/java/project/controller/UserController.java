package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.listUser();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String newUser(User user) {
        return "new";
    }

    @PostMapping("/new")
    public String create(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.removeUser(userService.getUserById(id));
        return "redirect:/users";
    }
}
