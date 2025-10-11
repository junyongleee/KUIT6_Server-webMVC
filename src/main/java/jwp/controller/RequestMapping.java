package jwp.controller;

import jwp.controller.HomeController;
import java.util.HashMap;
import java.util.Map;

public class RequestMapping {
    private final Map<String, Controller> mappings = new HashMap<>();

    public void init() {
        mappings.put("/", new HomeController());
        mappings.put("/user/login", new LoginController());
        mappings.put("/user/logout", new LogoutController());
        mappings.put("/user/updateForm", new UpdateUserFormController());
        mappings.put("/user/update", new UpdateUserController());
        mappings.put("/user/list", new ListUserController());
        mappings.put("/user/loginFailed", new ForwardController("/user/loginFailed.jsp"));
    }

    public Controller getController(String path) {
        return mappings.get(path);
    }
}