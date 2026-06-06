package filePractice;

import com.codeborne.selenide.logevents.SelenideLogger;
import filePractice.utils.XlsHelper;
import filePractice.utils.ZipHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    ZipHelper zipHelper = new ZipHelper();
    XlsHelper xlsHelper = new XlsHelper();

    @BeforeAll
    static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
