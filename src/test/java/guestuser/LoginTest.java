package guestuser;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static page.LoginPage.*;

public class LoginTest extends BaseTest {

    @Test
    void shouldDisplayLogin() {
        page.navigate(BASE_URL);
        assertEquals(LOGIN_URL, page.url());
    }

    @Test
    void shouldLogin() {
        page.navigate(BASE_URL);
        page.locator(USERNAME_FIELD_LOCATOR).fill(USERNAME_VALUE);
        page.locator(PASSWORD_FIELD_LOCATOR).fill(PASSWORD_VALUE);
        page.locator(LOGIN_BUTTON_LOCATOR).click();
        assertEquals(BASE_URL, page.url());
    }

    @Test
    void shouldLogout() {
        page.navigate(BASE_URL);
        page.locator(USERNAME_FIELD_LOCATOR).fill(USERNAME_VALUE);
        page.locator(PASSWORD_FIELD_LOCATOR).fill(PASSWORD_VALUE);
        page.locator(LOGIN_BUTTON_LOCATOR).click();
        page.locator(LOGOUT_BUTTON_LOCATOR).click();
        assertEquals(LOGOUT_URL, page.url());
    }

}
