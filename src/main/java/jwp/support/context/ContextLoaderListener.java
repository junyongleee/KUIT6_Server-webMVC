//package jwp.controller;
//
//import jwp.service.UserService;
//import jwp.support.session.UserSessionUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/user")
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//
//    @GetMapping("/list")
//    public String listUsers(HttpSession session, Model model) {
//        if (!UserSessionUtils.isLogined(session)) {
//            return "redirect:/user/loginForm";
//        }
//        model.addAttribute("users", userService.findAllUsers());
//        return "user/list";
//    }
//}