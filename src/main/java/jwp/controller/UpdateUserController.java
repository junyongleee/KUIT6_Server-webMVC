//package jwp.controller;
//
//import jwp.model.User;
//import jwp.service.UserService;
//import jwp.support.session.UserSessionUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//
//@Controller
//@RequestMapping("/user")
//@RequiredArgsConstructor
//public class UpdateUserController {
//    private final UserService userService;
//    @PostMapping("/update")
//    public String updateUser(@ModelAttribute User updateUser, HttpSession session) {
//        User sessionUser = UserSessionUtils.getUserFromSession(session);
//        if (sessionUser == null || !sessionUser.isSameUser(updateUser.getUserId())) {
//            return "redirect:/";
//        }
//        User persistedUser = userService.updateUser(updateUser);
//        session.setAttribute(UserSessionUtils.USER_SESSION_KEY, persistedUser);
//        return "redirect:/user/list";
//    }
//}