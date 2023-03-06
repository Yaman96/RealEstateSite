package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

//    @Autowired
//    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
//        List<User> userList = userService.getAllUsers();
//        model.addAttribute("userList", userList);
        return "temp users-list";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
//        User requestedUser = userService.getById(id).orElseThrow( () -> new IllegalArgumentException("Invalid user id:" + id));
//        model.addAttribute("requestedUser", requestedUser);
        return "temp user-info";
    }
}
