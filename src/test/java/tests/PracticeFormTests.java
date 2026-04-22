package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultModalComponent;


import static tests.testdata.TestDataPracticeForm.*;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultModalComponent resultModalComponent = new ResultModalComponent();

   @Test // Заполнение всех полей формы
    void successfulFormCompletionTest(){
        practiceFormPage.openPage()
                .bannerClose()
                .checkSubtitle(subtitleText)
                .typeFirstName(firstName)
                .typeLastName(secondName)
                .typeEmail(userEmail)
                .selectGender(genderTextValue)
                .typeNumber(userNumber)
                .setDateOfBirth(dateDay, dateMonth, dateYear)
                .selectSubject(subject)
                .selectHobbie(hobbie)
                .uploadPicture(uploadPicture)
                .typeCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .submitForm();

    resultModalComponent.checkResultModalAppearance()
                .checkResultModalTitle(successSubmitText)
                .checkResultField("Student Name", firstName + " " + secondName)
                .checkResultField("Student Email", userEmail)
                .checkResultField("Gender", genderTextValue)
                .checkResultField("Date of Birth", dateOfBirth)
                .checkResultField("Subjects", subject)
                .checkResultField("Hobbies", hobbie)
                .checkResultField("Picture", uploadPicture)
                .checkResultField("Address", currentAddress)
                .checkResultField("State and City", state + " " + city);

    }

    @Test  // Заполнение только обязательных полей
    void requiredFieldsOnlyTest() {
        practiceFormPage.openPage()
                .bannerClose()
                .checkSubtitle(subtitleText)
                .typeFirstName(firstName)
                .typeLastName(secondName)
                .typeEmail(userEmail)
                .selectGender(genderTextValue)
                .typeNumber(userNumber)
                .setDateOfBirth(dateDay, dateMonth, dateYear)
                .submitForm();

        resultModalComponent.checkResultModalAppearance()
                .checkResultModalTitle(successSubmitText);
    }

    @Test  // Отправка пустой формы
    void unsuccessfulSubmitTest(){
       practiceFormPage.openPage()
               .bannerClose()
               .submitForm()
               .checkFormErrorText(formError);
    }

    @Test  // Отправка формы с некорректным номером телефона
    void incorrectNumberTest() {
       practiceFormPage.openPage()
               .bannerClose()
               .typeFirstName(firstName)
               .typeLastName(secondName)
               .typeEmail(userEmail)
               .typeNumber(incorrectUserNumber)
               .submitForm()
               .checkFormErrorText(formError);
   }

    @Test  // Отправка формы с пустым полем First Name
    void submitWithoutNameTest() {
        practiceFormPage.openPage()
                .bannerClose()
                .typeLastName(secondName)
                .typeEmail(userEmail)
                .typeNumber(userNumber)
                .submitForm()
                .checkFormErrorText(formError);
    }
}
