package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/signup")
public class CreateUserController extends HttpServlet { // HttpServlet 상속받음
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 객체 생성
        User user = new User(req.getParameter("userId"),
                    req.getParameter("password"),
                    req.getParameter("name"),
                    req.getParameter("email"));
        MemoryUserRepository.getInstance().addUser(user); // repository에 저장
        System.out.println("User 회원가입 끝");
        resp.sendRedirect("/user/list");
        // /user/list를 받는 controller 생성

        // super.doPost(req, resp);
    }






























}
