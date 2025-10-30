package jwp.controller;

//import core.db.MemoryUserRepository;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserController implements Controller {
    private static final String USER_SESSION_KEY = "user";
//    private static final MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
    private final UserDao userDao = new UserDao();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        if (!"POST".equalsIgnoreCase(req.getMethod())) {
            return "redirect:/";
        }

        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/";
        }

        User sessionUser = (User) session.getAttribute(USER_SESSION_KEY);
        String userId = req.getParameter("userId");
        if (sessionUser == null || !sessionUser.isSameUser(userId)) {
            return "redirect:/";
        }

        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        User updateUser = new User(userId, password, name, email);
        userDao.update(updateUser);

        session.setAttribute(USER_SESSION_KEY, updateUser);
        return "redirect:/user/list";
    }
}

//@WebServlet("/user/update")
//public class UpdateUserController extends HttpServlet {
//    private static final String USER_SESSION_KEY = "user";
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if (session == null) {
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
//
//        User sessionUser = (User) session.getAttribute(USER_SESSION_KEY);
//        String userId = req.getParameter("userId");
//        if (sessionUser == null || !sessionUser.isSameUser(userId)) {
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
//
//        String password = req.getParameter("password");
//        String name = req.getParameter("name");
//        String email = req.getParameter("email");
//
//        User updateUser = new User(userId, password, name, email);
//        MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
//        userRepository.changeUserInfo(updateUser);
//
//        session.setAttribute(USER_SESSION_KEY, updateUser);
//        resp.sendRedirect(req.getContextPath() + "/user/list");
//    }
//}