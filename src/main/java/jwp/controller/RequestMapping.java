package jwp.controller;

import jwp.controller.HomeController;
import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private final Map<String, Controller> mappings = new HashMap<>();

    public void init() {
        mappings.put("/", new HomeController());
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/loginForm", new ForwardController("/user/login.jsp"));
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/updateForm", new UpdateUserFormController());
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));
        mappings.put("/qna/form", new CreateQuestionFormController());
        mappings.put("/qna/create", new CreateQuestionController());
        mappings.put("/qna/show", new ShowQuestionController());
    }


    public Controller getController(String path) {
        return mappings.get(path);
    }
}