package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.servise.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/allusers")
    public String printAllUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "user";
    }

    @GetMapping(value = "/adduser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newuser";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/allusers";
    }

    @GetMapping("/deleteuser")
    public String showDeleteUser() {
        return "delete";
    }

    @PostMapping("/deleteuser")
    public String DeleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/allusers";
    }

    @GetMapping("/edituser")
    public String showUpdateUserForm(@RequestParam("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edituser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/allusers";
    }

}
