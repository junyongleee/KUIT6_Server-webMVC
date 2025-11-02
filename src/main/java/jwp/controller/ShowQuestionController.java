package jwp.controller;

import jwp.dao.QuestionDao;
import jwp.model.Question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ShowQuestionController implements Controller {
    private final QuestionDao questionDao = new QuestionDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String questionIdParam = req.getParameter("questionId");
        if (questionIdParam == null || questionIdParam.isBlank()) {
            resp.sendRedirect("/");
            return null;
        }

        long questionId;
        try {
            questionId = Long.parseLong(questionIdParam);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return null;
        }

        Question question = questionDao.findByQuestionId(questionId);
        if (question == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }

        req.setAttribute("question", question);
        return "/qna/show.jsp";
    }
}
