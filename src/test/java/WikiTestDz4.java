import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WikiTestDz4 {
    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("https://github.com");
        $(".search-input-container").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[data-testid=results-list]").$$("a").get(0).shouldHave(text("selenide/selenide")).click();
        $("#wiki-tab").click();
        $$(".internal").findBy(text("Soft assertions")).click();
        $("#wiki-content").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));

    }
}
