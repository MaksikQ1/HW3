package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;

public class TextBoxTestsMInColDannyh extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Maks")
                .setLastName("Familiya")
                .setGender("Male")
                .setUserNumber("9999999999")
                .submitForm();

        ResultTableComponent resultTable = registrationPage.getResultTable();
        resultTable.checkResult("Student Name", "Maks Familiya")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999");

    }
}