package jwp.controller;

import jwp.dao.QuestionDao;
import jwp.model.Question;
import jwp.model.User;
import jwp.support.session.UserSessionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CreateQuestionController implements Controller {
    private final QuestionDao questionDao = new QuestionDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        if (!"POST".equalsIgnoreCase(req.getMethod())) {
            return "redirect:/qna/form";
        }

        HttpSession session = req.getSession(false);
        if (!UserSessionUtils.isLogined(session)) {
            return "redirect:/user/loginForm";
        }

        User user = UserSessionUtils.getUserFromSession(session);
        String title = req.getParameter("title");
        String contents = req.getParameter("contents");

        Question newQuestion = new Question(null, user.getUserId(), title, contents, null, 0);
        questionDao.insert(newQuestion);

        return "redirect:/";
    }
}
