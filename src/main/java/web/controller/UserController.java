package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    @GetMapping("/list")
    public String listUsers(Model theModel) {
        //get the users from the db
        List<User> theUsers = userService.findAllUsers();
        //add to the spring model
        theModel.addAttribute("users", theUsers);

        return "list-users";
    }
    @GetMapping("/showForm")
    public String showForm(Model theModel) {
        User theUser = new User();
        theModel.addAttribute("user", theUser);
        return "user-form";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser) {
        System.out.println("User from web: " + theUser);
        userService.save(theUser);
        return "redirect:/users/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
        User theUser = userService.findById(theId);

        //set user as model attribute to pre-populate the form
        theModel.addAttribute("user", theUser);
        //send over to the form
        return "user-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int theId) {
        userService.deleteById(theId);
        return "redirect:/users/list";
    }
}
