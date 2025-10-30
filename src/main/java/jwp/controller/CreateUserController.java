package jwp.controller;

import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/signup")
public class CreateUserController extends HttpServlet { // HttpServlet 상속받음
    private final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 객체 생성
        User user = new User(req.getParameter("userId"),
                    req.getParameter("password"),
                    req.getParameter("name"),
                    req.getParameter("email"));

        try {
            userDao.insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User 회원가입 끝");
        resp.sendRedirect("/user/list");
    }






























}
