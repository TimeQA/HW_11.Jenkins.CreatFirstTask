package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.Attach.Attach;

public class TestBase {
    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();


        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        if (System.getProperty("remote") != null) {
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = System.getProperty("remote");
        }
    }
//    https://user1:1234@selenoid.autotests.cloud/wd/hub
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (System.getProperty("selenide.remote") != null) {
            Attach.addVideo();
        }
    }
}