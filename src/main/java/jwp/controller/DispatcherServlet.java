//package jwp.controller;
//
//import jwp.controller.RequestMapping;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet("/")
//public class DispatcherServlet extends HttpServlet {
//    private static final String REDIRECT_PREFIX = "redirect:";
//
//    private RequestMapping requestMapping;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        this.requestMapping = new RequestMapping();
//        this.requestMapping.init();
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String viewName = null;
//        try {
//            viewName = resolveViewName(req, resp);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        if (viewName == null) {
//            return;
//        }
//
//        if (viewName.startsWith(REDIRECT_PREFIX)) {
//            String redirectPath = viewName.substring(REDIRECT_PREFIX.length());
//            resp.sendRedirect(req.getContextPath() + redirectPath);
//            return;
//        }
//
//        RequestDispatcher rd = req.getRequestDispatcher(viewName);
//        rd.forward(req, resp);
//    }
//
//    private String resolveViewName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
//        String requestUri = req.getRequestURI();
//        String contextPath = req.getContextPath();
//        String path = requestUri.substring(contextPath.length());
//
//        Controller controller = requestMapping.getController(path);
//        if (controller == null) {
//            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return null;
//        }
//
//        return controller.execute(req, resp);
//    }
//}