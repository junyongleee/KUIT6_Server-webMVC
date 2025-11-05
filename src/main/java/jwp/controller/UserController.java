package jwp.controller;

import jwp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public String listUsers(HttpServletRequest req, Model model) {
        if (!"GET".equalsIgnoreCase(req.getMethod())) {
            return "redirect:/user/login";
        }

        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/user/login";
        }

        model.addAttribute("users", userService.findAllUsers());
        return "user/list.jsp";
    }
}
