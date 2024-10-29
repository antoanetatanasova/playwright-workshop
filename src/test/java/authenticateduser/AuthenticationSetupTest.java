package authenticateduser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Paths;

import static page.BasePage.BASE_URL;
import static page.LoginPage.*;

public class AuthenticationSetupTest extends BaseTest {

    @BeforeEach
    void createAuthenticatedContext() {
        page.navigate(BASE_URL);
        page.locator(USERNAME_FIELD_LOCATOR).fill(USERNAME_VALUE);
        page.locator(PASSWORD_FIELD_LOCATOR).fill(PASSWORD_VALUE);
        page.locator(LOGIN_BUTTON_LOCATOR).click();

        // Save storage state into the file.
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));

        // Create a new context with the saved storage state.
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));
    }

}
