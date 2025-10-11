package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/updateForm")
public class UpdateUserFormController implements Controller {
    private static final String USER_SESSION_KEY = "user";
    private static final MemoryUserRepository userRepository = MemoryUserRepository.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!"GET".equalsIgnoreCase(req.getMethod())) {
            return "redirect:/";
        }

        String userId = req.getParameter("userId");
        HttpSession session = req.getSession(false);
        if (session == null) {
            return "redirect:/";
        }

        User sessionUser = (User) session.getAttribute(USER_SESSION_KEY);
        if (sessionUser == null || !sessionUser.isSameUser(userId)) {
            return "redirect:/";
        }

        User user = userRepository.findUserById(userId);
        if (user == null) {
            return "redirect:/";
        }

        req.setAttribute("user", user);
        return "/user/updateForm.jsp";
    }
}

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userId = req.getParameter("userId");
//
//        HttpSession session = req.getSession(false);
//        if (session == null) {
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
//
//        User sessionUser = (User) session.getAttribute(USER_SESSION_KEY);
//        if (sessionUser == null || !sessionUser.isSameUser(userId)) {
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
//
//        MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
//        User user = userRepository.findUserById(userId);
//        if (user == null) {
//            resp.sendRedirect(req.getContextPath() + "/");
//            return;
//        }
//
//        req.setAttribute("user", user);
//        RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
//        rd.forward(req, resp);
//    }
//}