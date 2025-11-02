package jwp.controller;

import jwp.support.session.UserSessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller {
//    private static final String USER_SESSION_KEY = "user";

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
        }
        return "redirect:/";
    }
}

//@WebServlet("/user/logout")
//public class LogoutController extends HttpServlet {
//    private static final String USER_SESSION_KEY = "user";
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        if (session != null) {
//            session.removeAttribute(USER_SESSION_KEY);
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/");
//    }
//}