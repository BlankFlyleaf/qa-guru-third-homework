package ru.avito.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import ru.avito.data.NameOfCategory;

public class AvitoTest extends TestBase {

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @ValueSource (strings = {
            "Настольные игры",
            "Шампунь",
            "Лодка"
    })
    @ParameterizedTest
    @Tag("Blocker")
    @Disabled
    @DisplayName("Проверка поиска по объявлениям Авито c запросом {0}")
    public void avitoProductSearchTest(String search) {
            avitoPage
                    .openUrl()
                    .typeSearch(search)
                    .submitSearch()
                    .outputCheck(search);
    }

    @CsvSource(value = {
            "Настольные игры, Москва, Москвы",
            "Шампунь, Псков, Пскова",
            "Лодка, Магадан, Магадана"
    })
    @ParameterizedTest
    @Tag("Blocker")
    @Disabled
    @DisplayName("Проверка поиска по объявлениям Авито с запросом {0} по городу {1}")
    public void avitoProductSearchByTownTest(String search, String city, String expectedCity) {
        avitoPage
                .openUrl()
                .changeLocation()
                .typeLocation("")
                .typeLocation(city)
                .saveLocation()
                .typeSearch(search)
                .submitSearch()
                .outputCheck(search)
                .titleCheck("«" + search + "»: объявления для " + expectedCity);
    }

    @EnumSource(NameOfCategory.class)
    @ParameterizedTest
    @Tag("Blocker")
    @Disabled
    @DisplayName("Проверка заголовков подкатегории {0}")
    public void categoryHeaderTest(NameOfCategory nameOfCategory) {
        avitoPage
                .openUrl()
                .clickCategory()
                .clickSubCategory(nameOfCategory.category)
                .titleCheck("Купить " + nameOfCategory.description + " в Воронеже");
    }
}
