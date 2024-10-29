package authenticateduser;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static conponent.NavigationMenu.*;
import static page.PropertyPage.ADD_BUTTON_LOCATOR;

public class NavigationTest extends AuthenticationSetupTest {

    @Test
    void shouldFilterByGuest() {
        page.locator(ADD_BUTTON_LOCATOR).click();
        page.locator(NAV_FILTER_INPUT_FIELD_LOCATOR).fill("Guest");
        assertThat(page.locator(NAV_CURRENT_OPTION_LOCATOR)).isHidden();
        assertThat(page.locator(NAV_RESERVATIONS_OPTION_LOCATOR)).isHidden();
    }

    @Test
    void shouldFilterByReservationPartialString() {
        page.locator(ADD_BUTTON_LOCATOR).click();
        page.locator(NAV_FILTER_INPUT_FIELD_LOCATOR).fill("rese");
        assertThat(page.locator(NAV_CURRENT_OPTION_LOCATOR)).isHidden();
        assertThat(page.locator(NAV_GUESTS_OPTION_LOCATOR)).isHidden();
    }
}
