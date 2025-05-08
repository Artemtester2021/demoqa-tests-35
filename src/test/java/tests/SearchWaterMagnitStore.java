package tests;

import com.codeborne.selenide.Configuration;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;

public class SearchWaterMagnitStore {

    @BeforeEach
    void setUp() {
        open("https://magnit.ru");
        Configuration.pageLoadStrategy = "eager";
    }

    {
        @ParameterizedTest
        @ValueSource(strings = {"Вода", "Кола", "Сок"})
        @DisplayName("Поиск товара по названию с одного значения")
        void productSearchTest (String @Nullable String productName; String expectedProductName)
        {
            expectedProductName = productName;
            $(".pl-input").click();
            $("[data-test-id='search-row']").setValue(productName).pressEnter();
            $(".pl-text.unit-catalog-product-preview-title");

        }


        @ParameterizedTest
        @CsvSource({
                "Вода, Вода Моя цена питьевая негазированная 5л",
                "Кола, Кола Моя цена газированная 1л",
                "Сок, Сок Моя цена 100% натуральный 1л"
        })
        @DisplayName("Поиск товара по названию с использованием CsvSource")
        void productSearchTest (String productName, String expectedProductName){
        $(".pl-input").click();
        $("[data-test-id='search-row']").setValue(productName).pressEnter();
        $(".pl-text.unit-catalog-product-preview-title")
                .shouldHave(text(expectedProductName));
    }

        @ParameterizedTest
        @MethodSource("productNames")
        @DisplayName("Поиск товара по названию")
        void productSearchTest (String productName, String expectedProductName){
        $(".pl-input").click();
        $("[data-test-id='search-row']").setValue(productName).pressEnter();
        $(".pl-text.unit-catalog-product-preview-title")
                .shouldHave(text(expectedProductName));
    }
    }
}
