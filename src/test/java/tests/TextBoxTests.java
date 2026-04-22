package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestDataTextBox.*;

public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test // Успешное заполнение и отправка формы
    void successfulFormCompletionTest(){
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(address)
                .typePermanentAddress(address)
                .submitForm()
                .checkField("name", expectedName)
                .checkField("email", expectedEmail)
                .checkField("currentAddress", expectedCurrentAddress)
                .checkField("permanentAddress", expectedPermanentAddress);
    }

    @Test // Отправка формы при некорректном значении Email
    void incorrectEmail(){
        textBoxPage.openPage()
                .typeUserEmail(incorrectUserEmail)
                .submitForm()
                .noOutput("email");
    }
}
