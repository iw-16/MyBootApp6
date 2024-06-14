package jp.te4a.spring.boot.myapp13.mybootapp13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import jp.te4a.spring.boot.myapp13.mybootapp13.form.UserForm;
import jp.te4a.spring.boot.myapp13.mybootapp13.service.UserService;

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @ModelAttribute 
    UserForm setUpForm() {
        return new UserForm();
    }
    @GetMapping
    String list(Model model) {
        return "users/add";
    }
    @PostMapping(path="create")
        String create(@Validated UserForm form, BindingResult result, Model model) {
            if(result.hasErrors()) {
                 return list(model);
            }
            userService.create(form);
            return "redirect:/users";
    }
}

