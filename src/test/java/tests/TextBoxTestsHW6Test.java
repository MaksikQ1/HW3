package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;

public class TextBoxTestsHW6Test extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Maks")
                .setLastName("Familiya")
                .setEmail("Maks@Familiya.com")
                .setGender("Male")
                .setUserNumber("9999999999")
                .setDateOfBirth("06", "October", "2001")
                .setSubject("Math")
                .setHobby("Sports")
                .uploadPicture("ChillGuy.jpg")
                .setCurrentAddress("Пушкина")
                .setStateAndCity("Haryana","Karnal")
                .submitForm();

        ResultTableComponent resultTable = registrationPage.getResultTable();
        resultTable.checkResult("Student Name", "Maks Familiya")
                .checkResult("Student Email", "Maks@Familiya.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999999")
                .checkResult("Date of Birth", "06" + " " + "October" + "," + "2001")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "ChillGuy.jpg")
                .checkResult("Address", "Пушкина")
                .checkResult("State and City", "Haryana"  + " " + "Karnal");

    }

    @Test
    void negativeTest(){

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Maks")
                .setLastName("Familiya")
                .setEmail("Maks@Familiya")
                .setGender("Male")
                .setUserNumber("54321")
                .submitForm();

        registrationPage.checkErrorField();

    }
}