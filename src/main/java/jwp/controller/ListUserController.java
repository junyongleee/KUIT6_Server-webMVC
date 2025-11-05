//package jwp.controller;
//
//import core.db.MemoryUserRepository;
//import jwp.dao.UserDao;
//import jwp.model.User;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Collection;
//
////@WebServlet("/user/list")
//public class ListUserController implements Controller {
//    private static final String USER_SESSION_KEY = "user";
////    private static final MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
//    private final UserDao userDao = new UserDao();
//
//    @Override
//    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (!"GET".equalsIgnoreCase(req.getMethod())) {
//            return "redirect:/user/login";
//        }
//
//        HttpSession session = req.getSession(false);
//        if (session == null) {
//            return "redirect:/user/login";
//        }
//
//        User user = (User) session.getAttribute(USER_SESSION_KEY);
//        if (user == null) {
//            return "redirect:/user/login";
//        }
//
//        Collection<User> users = null;
//        try {
//            users = userDao.findAll();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        req.setAttribute("users", users);
//        return "/user/list.jsp";
//    }
//}
////    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        HttpSession session = req.getSession(false);
////        if (session == null) {
////            resp.sendRedirect(req.getContextPath() + "/user/login");
////            return;
////        }
////
////        User user = (User) session.getAttribute(USER_SESSION_KEY);
////        if (user == null) {
////            resp.sendRedirect(req.getContextPath() + "/user/login");
////            return;
////        }
////
////        MemoryUserRepository userRepository = MemoryUserRepository.getInstance();
////        Collection<User> users = userRepository.findAll();
////        req.setAttribute("users", users);
////
////        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
////        rd.forward(req, resp);
////    }
//
