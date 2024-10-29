package guestuser;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static page.BasePage.BASE_PAGE_TITLE;
import static page.BasePage.BASE_URL;

public class SmokeTest extends BaseTest {

    @Test
    void shouldHaveTitle() {
        page.navigate(BASE_URL);
        assertThat(page).hasTitle(Pattern.compile(BASE_PAGE_TITLE));
    }

}
