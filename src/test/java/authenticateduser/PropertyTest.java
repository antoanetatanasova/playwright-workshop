package authenticateduser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PropertyPage;

import java.io.IOException;
import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static page.PropertyPage.*;

public class PropertyTest extends AuthenticationSetupTest {

    PropertyPage propertyPage = new PropertyPage();

    @BeforeEach
    void clickOnAddPropertyButton() {
        page.locator(ADD_BUTTON_LOCATOR).click();
    }

    @Test
    void shouldOpenAddProperty() {
        assertThat(page.locator(SUBMIT_COMPONENT_LOCATOR)).isVisible();
    }

    @Test
    void shouldAddProperty() {
        page.locator(ADDRESS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomAddress());
        page.locator(NUMBER_OF_BEDS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomNumberOfBeds());
        page.locator(SAVE_BUTTON_LOCATOR).click();
        assertThat(page.locator(SUCCESS_LOCATOR)).isVisible();
    }

    @Test
    void shouldAddPropertyWithImage() throws IOException {
        page.locator(ADDRESS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomAddress());
        page.locator(NUMBER_OF_BEDS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomNumberOfBeds());
        page.setInputFiles(FILE_UPLOAD_BUTTON_LOCATOR, Paths.get("src/test/resources/test_image.jpg"));
        page.locator(SAVE_BUTTON_LOCATOR).click();
        assertThat(page.locator(SUCCESS_LOCATOR)).isVisible();
    }

    @Test
    void shouldAddPropertyAndOpenAddAnotherPage() {
        page.locator(ADDRESS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomAddress());
        page.locator(NUMBER_OF_BEDS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomNumberOfBeds());
        page.locator(SAVE_AND_ADD_ANOTHER_BUTTON_LOCATOR).click();
        assertThat(page.locator(SUCCESS_LOCATOR)).isVisible();
    }

    @Test
    void shouldAddPropertyAndStayOnContinueEditingPage() {
        page.locator(ADDRESS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomAddress());
        page.locator(NUMBER_OF_BEDS_INPUT_FIELD_LOCATOR).fill(propertyPage.generateRandomNumberOfBeds());
        page.locator(SAVE_AND_CONTINUE_EDITING_BUTTON_LOCATOR).click();
        assertThat(page.locator(SUCCESS_LOCATOR)).isVisible();
    }

}
