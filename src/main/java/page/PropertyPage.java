package page;

import java.util.Random;

public class PropertyPage extends BasePage {

    //Locators
    public static final String ADD_BUTTON_LOCATOR = ".model-property .addlink";
    public static final String SUBMIT_COMPONENT_LOCATOR = ".submit-row";
    public static final String ADDRESS_INPUT_FIELD_LOCATOR = "#id_address";
    public static final String NUMBER_OF_BEDS_INPUT_FIELD_LOCATOR = "#id_number_of_beds";
    public static final String FILE_UPLOAD_BUTTON_LOCATOR = "#id_cover";
    public static final String SAVE_BUTTON_LOCATOR = ".default";
    public static final String SAVE_AND_ADD_ANOTHER_BUTTON_LOCATOR = "//input[@type='submit'][2]";
    public static final String SAVE_AND_CONTINUE_EDITING_BUTTON_LOCATOR = "//input[@type='submit'][3]";
    public static final String SUCCESS_LOCATOR = ".success";


    // Test Data
    public String generateRandomAddress() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        String generatedAddress = buffer.toString();
        return generatedAddress;
    }

    public String generateRandomNumberOfBeds() {
        Random random = new Random();
        int numberOfBeds = random.nextInt(7);
        return String.valueOf(numberOfBeds);
    }
}
