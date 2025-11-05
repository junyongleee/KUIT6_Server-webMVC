package jwp.controller;

import jwp.model.User;
import jwp.service.QuestionService;
import jwp.support.session.UserSessionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/qna")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/form")
    public String showForm(HttpSession session) {
        if (UserSessionUtils.isLogined(session)) {
            return "qna/form.jsp";
        }
        return "redirect:/user/loginForm";
    }

    @PostMapping("/create")
    public String createQuestion(@RequestParam String title,
                                 @RequestParam String contents,
                                 HttpSession session) {
        User user = UserSessionUtils.getUserFromSession(session);
        if (user == null) {
            return "redirect:/user/loginForm";
        }
        questionService.createQuestion(user.getUserId(), title, contents);
        return "redirect:/";
    }

    @GetMapping("/show")
    public String showQuestion(@RequestParam Long questionId, Model model) {
        return questionService.findById(questionId)
                .map(question -> {
                    model.addAttribute("question", question);
                    return "qna/show";
                })
                .orElse("redirect:/");
    }
}
