package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void setupSelenideEnv(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://qa-guru.github.io/one-page-form";

    }
}
