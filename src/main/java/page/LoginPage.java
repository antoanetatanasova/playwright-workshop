package page;

import util.Utility;

import java.io.IOException;

public class LoginPage extends BasePage {

    //Test Data
    public static String USERNAME_VALUE;

    static {
        try {
            USERNAME_VALUE = Utility.fetchStringProperty("username");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String PASSWORD_VALUE;

    static {
        try {
            PASSWORD_VALUE = Utility.fetchStringProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Input Field Locator
    public static String USERNAME_FIELD_LOCATOR = "#id_username";
    public static String PASSWORD_FIELD_LOCATOR = "#id_password";

    //Button Locator
    public static String LOGIN_BUTTON_LOCATOR = "//*[@value=\"Log in\"]";
    public static String LOGOUT_BUTTON_LOCATOR = "#logout-form";

    //URL
    public static String LOGIN_URL = BASE_URL + "login/?next=/admin/";
    public static String LOGOUT_URL = BASE_URL + "logout/";

}
