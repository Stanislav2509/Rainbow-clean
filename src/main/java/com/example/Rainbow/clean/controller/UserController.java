package com.example.Rainbow.clean.controller;

import com.example.Rainbow.clean.model.dto.UserRegisterBindingModel;
import com.example.Rainbow.clean.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String  register(@ModelAttribute("userRegisterBindingModel")UserRegisterBindingModel userRegisterBindingModel) {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute("userRegisterBindingModel") @Valid UserRegisterBindingModel userRegisterBindingModel,
            BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ModelAndView("register");
        }

        boolean hasSuccessfullyRegistration = userService.register(userRegisterBindingModel);

           if(!hasSuccessfullyRegistration){
                ModelAndView modelAndView = new ModelAndView("register");
                modelAndView.addObject("hasRegistrationError", true);
                return modelAndView;
           }

        return new ModelAndView("redirect:login");
    }

    @GetMapping("/login")
    public String  login() {

        return "login";
    }


    @PostMapping("/login-error")
    public String onFailure(@ModelAttribute("email") String email, Model model){
        model.addAttribute("email", email);
        model.addAttribute("bad_credentials", "true");

        return "login";
    }
}
