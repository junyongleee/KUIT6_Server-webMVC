package jwp.controller;

import jwp.dao.QuestionDao;
import jwp.dao.UserDao;
import jwp.model.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


public class HomeController implements Controller {
//	@Override
//	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<Question> questions = Collections.emptyList();
//		QuestionDao questionDao = new QuestionDao();
//
//		try {
//			questions = questionDao.findAll();
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		req.setAttribute("questions", questions);
//		return "/home.jsp";
//	}

	private final QuestionDao questionDao = new QuestionDao();

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Question> questions = Collections.emptyList();
		try {
			questions = questionDao.findAll();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		req.setAttribute("questions", questions);
		return "/home.jsp";
	}
}