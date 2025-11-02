package jwp.support.session;

import jwp.model.User;

import javax.servlet.http.HttpSession;

public final class UserSessionUtils {
    public static final String USER_SESSION_KEY = "user";

    private UserSessionUtils() {
    }

    public static boolean isLogined(HttpSession session) {
        return getUserFromSession(session) != null;
    }

    public static User getUserFromSession(HttpSession session) {
        if (session == null) {
            return null;
        }
        Object value = session.getAttribute(USER_SESSION_KEY);
        if (value instanceof User) {
            return (User) value;
        }
        return null;
    }
}