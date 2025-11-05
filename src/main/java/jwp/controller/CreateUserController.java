package jwp.controller;

import jwp.model.User;
import jwp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class CreateUserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/user/list";
    }
}
