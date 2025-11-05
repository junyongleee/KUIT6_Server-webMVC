//package jwp.controller;
//
//import jwp.model.User;
//import jwp.service.UserService;
//import jwp.support.session.UserSessionUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/user")
//@RequiredArgsConstructor
//public class UpdateUserFormController {
//    private final UserService userService;
//
//    @GetMapping("/updateForm")
//    public String showUpdateForm(@RequestParam String userId, HttpSession session, Model model) {
//        User sessionUser = UserSessionUtils.getUserFromSession(session);
//        if (sessionUser == null || !sessionUser.isSameUser(userId)) {
//            return "redirect:/";
//        }
//        return userService.findByUserId(userId)
//                .map(user -> {
//                    model.addAttribute("user", user);
//                    return "user/updateForm";
//                })
//                .orElse("redirect:/");
//    }
//}