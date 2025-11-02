package jwp.controller;

import jwp.support.session.UserSessionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateQuestionFormController implements Controller {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (UserSessionUtils.isLogined(session)) {
            return "/qna/form.jsp";
        }
        return "redirect:/user/loginForm";
    }
}
