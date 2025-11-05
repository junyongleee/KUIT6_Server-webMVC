package jwp.controller;

import jwp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/qna")
@RequiredArgsConstructor
public class ShowQuestionController {
    private final QuestionService questionService;

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