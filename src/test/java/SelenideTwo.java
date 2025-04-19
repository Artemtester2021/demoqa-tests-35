import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTwo {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void transitionInEnterprizeTest() {
        open("https://github.com");
        $$("button").findBy(text("Solutions")).hover();
        $$("a[class^='HeaderMenu-dropdown-link']").findBy(text("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }

    @Test
    void dragAndDropeTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
        /*
При использовании предолженной команды: $("#column-a").dragAndDrop($("#column-b")) получаю ошибку.
Idea предлогает отредактировать добавив DragAndDropOptions.to
В итоге получаю следующую команду: $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
 */
    }
}



