package jwp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForwardController  {
//    private final String viewName;
    @GetMapping("/user/loginForm")
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("/user/loginFailed")
    public String loginFailed() {
        return "user/loginFailed";
    }

    @GetMapping("/user/form")
    public String signUpForm() {
        return "user/form";
    }
}