package jwp.controller;

import jwp.model.User;
import jwp.service.UserService;
import jwp.support.session.UserSessionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/form")
    public String signUpForm() {
        return "user/form";
    }

    @PostMapping("/signup")
    public String createUser(@RequestParam String userId,
                             @RequestParam String password,
                             @RequestParam String name,
                             @RequestParam String email) {
        userService.createUser(new User(userId, password, name, email));
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String listUsers(HttpSession session, Model model) {
        if (!UserSessionUtils.isLogined(session)) {
            return "redirect:/user/loginForm";
        }
        model.addAttribute("users", userService.findAllUsers());
        return "user/list";
    }


    @GetMapping("/updateForm")
    public String showUpdateForm(@RequestParam String userId,
                                 HttpSession session,
                                 Model model) {
        User sessionUser = UserSessionUtils.getUserFromSession(session);
        if (sessionUser == null || !sessionUser.isSameUser(userId)) {
            return "redirect:/";
        }
        return userService.findByUserId(userId)
                .map(user -> {
                    model.addAttribute("user", user);
                    return "user/updateForm";
                })
                .orElse("redirect:/");
    }

    @PostMapping("/update")
    public String updateUser(@RequestParam String userId,
                             @RequestParam String password,
                             @RequestParam String name,
                             @RequestParam String email,
                             HttpSession session) {
        User sessionUser = UserSessionUtils.getUserFromSession(session);
        if (sessionUser == null || !sessionUser.isSameUser(userId)) {
            return "redirect:/";
        }
        User persistedUser = userService.updateUser(new User(userId, password, name, email));
        session.setAttribute(UserSessionUtils.USER_SESSION_KEY, persistedUser);
        return "redirect:/user/list";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/login";
    }

    @GetMapping("/loginFailed")
    public String loginFailed() {
        return "user/loginFailed";
    }

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

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
        }
        return "redirect:/";
    }
}