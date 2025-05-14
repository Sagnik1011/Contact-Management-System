package ContactManagementSys;

import java.util.*;

public class InputChecking {
    public static boolean isCorrectName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    public static boolean isCorrectPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    public static boolean isCorrectEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{3}$");
    }
}
