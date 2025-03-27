package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.RegistrationPageWithFaker;
import pages.components.ResultTableComponent;

import static tests.TestData.*;

public class TextBoxTestsHW6WithFakerTest extends TestBase {
    RegistrationPageWithFaker registrationPage = new RegistrationPageWithFaker();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender()
                .setUserNumber(userNumber)
                .setDateOfBirth()
                .setSubject()
                .setHobby()
                .uploadPicture()
                .setCurrentAddress()
                .setStateAndCity()
                .submitForm();

        ResultTableComponent resultTable = registrationPage.getResultTable();
        resultTable.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state  + " " + city);

    }

    @Test
    void negativeTest(){

        registrationPage.openPage()
                .removeBanners()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender()
                .setUserNumber(userNumberNegative)
                .submitForm();

        registrationPage.checkErrorField();

    }

    @Test
    void successfulRegistrationMinColDannyhTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName()
                .setLastName()
                .setGender()
                .setUserNumber(userNumber)
                .submitForm();

        ResultTableComponent resultTable = registrationPage.getResultTable();
        resultTable.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);

    }
}