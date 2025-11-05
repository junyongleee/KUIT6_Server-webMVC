//package jwp.controller;
//
//
//import jwp.model.Question;
//import jwp.model.User;
//import jwp.service.QuestionService;
//import jwp.support.session.UserSessionUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.SQLException;
//
//@Controller
//@RequestMapping("/qna")
//@RequiredArgsConstructor
//public class CreateQuestionController{
//    private final QuestionService questionService;
//    @PostMapping("/create")
//    public String createQuestion(@RequestParam String title,
//                                 @RequestParam String contents,
//                                 HttpSession session) {
//        User user = UserSessionUtils.getUserFromSession(session);
//        if (user == null) {
//            return "redirect:/user/loginForm";
//        }
//        questionService.createQuestion(user.getUserId(), title, contents);
//        return "redirect:/";
//    }
//}
