import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maks");
        $("#lastName").setValue("Familiya");
        $("#userEmail").setValue("Maks@Familiya.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__day--0" + "06").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").type("Math").pressEnter();
        $("#hobbies-checkbox-1").ancestor(".custom-checkbox").click();
        $("#hobbies-checkbox-3").ancestor(".custom-checkbox").click();
        $("#uploadPicture").uploadFromClasspath("ChillGuy.jpg");
        $("#currentAddress").setValue("Пушкина");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("Maks" + " " + "Familiya"));
        $(".modal-content").shouldHave(text("Maks@Familiya.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9999999999"));
        $(".modal-content").shouldHave(text("06" + " " + "October" + "," + "2001"));
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Sports, Music"));
        $(".modal-content").shouldHave(text("ChillGuy.jpg"));
        $(".modal-content").shouldHave(text("Пушкина"));
        $(".modal-content").shouldHave(text("Haryana"  + " " + "Karnal"));
    }
}