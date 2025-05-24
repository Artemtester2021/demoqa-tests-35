package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }



    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Открытие формы", () -> {
            open("/automation-practice-form");

            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");
        });
        step("Заполнение формы", () ->{
            $("#firstName").setValue("Andrei");
            $("#lastName").setValue("Inov");
            $("#userEmail").setValue("test@test.ru");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("7776665544");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("2005");
            $$("div.react-datepicker__day").findBy(text("3")).click();
            $("#subjectsInput").setValue("Maths").pressEnter();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#uploadPicture").uploadFromClasspath("img.png");
            $("#currentAddress").setValue("Some address");
            $("#state").click();
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#city").click();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            $("#submit").click();
        });
        step("Проверка данных", () -> {
            $(".table-responsive").shouldBe(visible);
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Andrei Inov"));
            $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.ru"));
            $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
            $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7776665544"));
            $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("03 May,2005"));
            $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
            $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
            $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("img.png"));
            $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Some address"));
            $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        });
    }
}