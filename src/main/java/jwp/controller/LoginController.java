package jwp.controller;

//import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class LoginController implements Controller {
    private static final String USER_SESSION_KEY = "user";
//    private static final MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
    private final UserDao userDao = new UserDao();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!"POST".equalsIgnoreCase(req.getMethod())) {
            return "/user/login.jsp";
        }

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        User user = null;
        try {
            user = userDao.findByUserId(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user != null && user.matchPassword(password)) {
            HttpSession session = req.getSession();
            session.setAttribute(USER_SESSION_KEY, user);
            return "redirect:/";
        }

        return "redirect:/user/loginFailed";
    }
}

//@WebServlet("/user/login")
//public class LoginController extends HttpServlet {
//    private static final String USER_SESSION_KEY = "user";
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher rd = req.getRequestDispatcher("/user/login.jsp");
//        rd.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userId = req.getParameter("userId");
//        String password = req.getParameter("password");
//
//        MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
//        User user = userRepository.findUserById(userId);
//        if (user != null && user.matchPassword(password)) {
//            HttpSession session = req.getSession();
//            session.setAttribute(USER_SESSION_KEY, user);
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/user/loginFailed.jsp");
//    }
//}