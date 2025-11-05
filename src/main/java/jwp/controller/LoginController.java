package jwp.controller;

import jwp.service.UserService;
import jwp.support.session.UserSessionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String userId,
                        @RequestParam String password,
                        HttpSession session) {
        return userService.authenticate(userId, password)
                .map(user -> {
                    session.setAttribute(UserSessionUtils.USER_SESSION_KEY, user);
                    return "redirect:/";
                })
                .orElse("redirect:/user/loginFailed");
    }
}