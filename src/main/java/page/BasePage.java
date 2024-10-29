package page;

import util.Utility;

import java.io.IOException;

public class BasePage {

    public static final String BASE_URL;

    static {
        try {
            BASE_URL = Utility.fetchStringProperty("baseURL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String BASE_PAGE_TITLE = "Log in | Django site admin";

}
