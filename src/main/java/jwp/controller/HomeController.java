package jwp.controller;

import jwp.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class HomeController {
	private final QuestionService questionService;
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("questions", questionService.findAll());
		return "home";
	}
}