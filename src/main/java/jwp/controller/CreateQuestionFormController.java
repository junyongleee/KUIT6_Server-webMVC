//package jwp.controller;
//
//import jwp.support.session.UserSessionUtils;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/qna")
//public class CreateQuestionFormController {
//
//    @GetMapping("/form")
//    public String showForm(HttpSession session) {
//        if (UserSessionUtils.isLogined(session)) {
//            return "qna/form.jsp";
//        }
//        return "redirect:/user/loginForm";
//    }
//}
