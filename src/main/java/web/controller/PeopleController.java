package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImp;

import java.util.List;
import java.util.Map;

@Controller
public class PeopleController {

    private final UserService userService;

    @Autowired
    public PeopleController (UserService userService) {this.userService = userService;}

    @RequestMapping("/")
    public ModelAndView home() {
        List<User> users = userService.listUsers();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("users", users);
        return mav;
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUser(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }




//    @GetMapping()
//    public String index(Model model) {
//        return null;
//    }
//
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        return "";
//    }
//
//    @GetMapping("/new")
//    public String addUser(Model model) {
//        //model.addAttribute("user", userService.add(new User()));
//        return "people/new";
//    }
}
