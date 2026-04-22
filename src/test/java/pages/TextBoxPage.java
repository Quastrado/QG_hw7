package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private final SelenideElement userNameInput = $("#userForm").$(byId("userName"));
    private final SelenideElement userEmailInput = $("#userForm").$(byId("userEmail"));
    private final SelenideElement currentAddressTextarea = $("#userForm").$(byId("currentAddress"));
    private final SelenideElement permanentAddressTextarea = $("#userForm").$(byId("permanentAddress"));
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputResults = $("#output");



    public TextBoxPage openPage() {
        open("/text-box.html");

        return this;
    }

    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public TextBoxPage typeCurrentAddress(String value) {
        currentAddressTextarea.setValue(value);

        return this;
    }

    public TextBoxPage typePermanentAddress(String value) {
        permanentAddressTextarea.setValue(value);

        return this;
    }

    public TextBoxPage submitForm(){
        submitButton.click();

        return this;
    }

    public TextBoxPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));

        return this;
    }

    public TextBoxPage noOutput(String key) {
        outputResults.$(byId(key)).shouldNotHave(visible);

        return this;
    }
}
