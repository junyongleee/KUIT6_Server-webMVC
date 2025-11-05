package jwp.controller;

import jwp.dao.UserDao;
import jwp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao = new UserDao();

    @PostMapping("/signup")
    protected String createUser(@ModelAttribute User user) throws Exception{
        // 객체 생성
        userDao.insert(user);
        System.out.println("User 회원가입 끝");
        return "/user/list";
    }

    @GetMapping("/list")
    public String listUsers(HttpServletRequest req, Model model) throws ServletException, IOException, SQLException {
        if (!"GET".equalsIgnoreCase(req.getMethod())) {
            return "redirect:/user/login";
        }

        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/user/login";
        }

        // User user = (User) session.getAttribute(USER_SESSION_KEY);
        model.addAttribute("users", userDao.findAll());

//        if (user == null) {
//            return "redirect:/user/login";
//        }

//        Collection<User> users = null;
//        try {
//            users = userDao.findAll();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
////        }
//        req.setAttribute("users", users);
        return "/user/list.jsp";
    }
}
