package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {

    private final SelenideElement banner = $("#fixedban");
    private final SelenideElement practiceFormWrapper = $(".practice-form-wrapper");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderBar = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement subjectsDropdown = $("#subjectsDropdown");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement pictureUploader = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement stateContainer = $("#stateCity-wrapper");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement submit = $("#submit");
    private final SelenideElement errorText = $("#formError");




    public PracticeFormPage openPage() {
        open("/automation-practice-form.html");

        return this;
    }

    public PracticeFormPage checkSubtitle(String subtitleText) {
        practiceFormWrapper.$(".subtitle").shouldHave(text(subtitleText));

        return this;
    }

    public PracticeFormPage typeFirstName(String value) {
        firstNameInput.click();
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeLastName(String value) {
        lastNameInput.click();
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage typeEmail(String value) {
        emailInput.click();
        emailInput.setValue(value);

        return this;
    }

    public PracticeFormPage selectGender(String genderTextValue) {
        genderBar.$(byText(genderTextValue)).click();

        return this;
    }

    public PracticeFormPage typeNumber(String value) {
        numberInput.click();
        numberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage selectSubject(String value) {
        subjectsInput.click();
        subjectsDropdown.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage selectHobbie(String value) {
        hobbiesWrapper.$(byValue(value)).click();

        return this;
    }

    public PracticeFormPage uploadPicture(String value) {
        pictureUploader.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage typeCurrentAddress(String value) {
        currentAddressInput.click();
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage selectState(String value) {
        stateSelect.click();
        stateContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage selectCity(String value) {
        citySelect.click();
        stateContainer.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage submitForm() {
        submit.click();

        return this;
    }


    public PracticeFormPage checkFormErrorText(String value) {
        errorText.shouldHave(text(value));

        return this;
    }

    public PracticeFormPage bannerClose() {
        banner.$(byTagName("button")).click();

        return this;
    }
}
