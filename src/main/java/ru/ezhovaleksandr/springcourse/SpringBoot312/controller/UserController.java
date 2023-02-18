package ru.ezhovaleksandr.springcourse.SpringBoot312.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ezhovaleksandr.springcourse.SpringBoot312.model.User;
import ru.ezhovaleksandr.springcourse.SpringBoot312.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "new";
        }
        userService.add(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap modelMap, @PathVariable("id") Integer id) {
        modelMap.addAttribute("user", userService.getById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult ) {
        if(bindingResult.hasErrors()) {
            return "edit";
        }
        userService.update(user);
        return "redirect:/users";
    }


    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
}