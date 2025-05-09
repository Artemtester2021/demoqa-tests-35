package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchWaterMagnitStore {
    @BeforeEach
    void setUp() {
        open("https://magnit.ru");
        Configuration.pageLoadStrategy = "eager";
    }

    @ValueSource(strings = {
            "Вода", "Кола", "Сок"
    })

    @ParameterizedTest(name = "Поиск товара по названию {0}")
    @Tag("SEARCH")
    void searchResultsDrink (String searchQuery) {
        $(".pl-input-field").setValue(searchQuery).pressEnter();
        $(".unit-catalog-product-preview-image");
    }

    @CsvSource(value = {
            "булочка , Булочка Венская Золотой колос 75г",
            "Коржик, Коржик Молочный Фарше 80г"
    })

    @ParameterizedTest(name = "Поиск товара по названию {0}, найден товар: {1}")
    @Tag("SEARCH")
    void searchResultsFlour(String searchQuery, String ProductName){
        $(".pl-input-field").setValue(searchQuery).pressEnter();
        $$(".pl-hover-base").filterBy(text(ProductName));
    }

    @CsvFileSource(resources = "/test_data/searchResultsСup.csv")

    @ParameterizedTest(name = "Поиск товара по названию {0}, найден товар: {1}")
    @Tag("SEARCH")
    void searchResultsСup(String searchQuery, String MugName ){
        $(".pl-input-field").setValue(searchQuery).pressEnter();
        $$(".pl-hover-base").filterBy(text(MugName ));
    }
}
