package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import pages.components.ResultModalComponent;
import tests.testdata.TestDataPracticeForm;


public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultModalComponent resultModalComponent = new ResultModalComponent();
    TestDataPracticeForm testData = new TestDataPracticeForm();

   @Test // Заполнение всех полей формы
    void successfulFormCompletionTest(){
        practiceFormPage.openPage()
                .bannerClose()
                .checkSubtitle(testData.subtitleText)
                .typeFirstName(testData.firstName)
                .typeLastName(testData.secondName)
                .typeEmail(testData.userEmail)
                .selectGender(testData.genderTextValue)
                .typeNumber(testData.userNumber)
                .setDateOfBirth(testData.dateDay, testData.dateMonth, testData.dateYear)
                .selectSubject(testData.subject)
                .selectHobbie(testData.hobbie)
                .uploadPicture(testData.uploadPicture)
                .typeCurrentAddress(testData.currentAddress)
                .selectState(testData.state)
                .selectCity(testData.city)
                .submitForm();

    resultModalComponent.checkResultModalAppearance()
                .checkResultModalTitle(testData.successSubmitText)
                .checkResultField("Student Name", testData.firstName + " " + testData.secondName)
                .checkResultField("Student Email", testData.userEmail)
                .checkResultField("Gender", testData.genderTextValue)
                .checkResultField("Date of Birth", testData.dateOfBirth)
                .checkResultField("Subjects", testData.subject)
                .checkResultField("Hobbies", testData.hobbie)
                .checkResultField("Picture", testData.uploadPicture)
                .checkResultField("Address", testData.currentAddress)
                .checkResultField("State and City", testData.state + " " + testData.city);

    }

    @Test  // Заполнение только обязательных полей
    void requiredFieldsOnlyTest() {
        practiceFormPage.openPage()
                .bannerClose()
                .checkSubtitle(testData.subtitleText)
                .typeFirstName(testData.firstName)
                .typeLastName(testData.secondName)
                .typeEmail(testData.userEmail)
                .selectGender(testData.genderTextValue)
                .typeNumber(testData.userNumber)
                .setDateOfBirth(testData.dateDay, testData.dateMonth, testData.dateYear)
                .submitForm();

        resultModalComponent.checkResultModalAppearance()
                .checkResultModalTitle(testData.successSubmitText);
    }

    @Test  // Отправка пустой формы
    void unsuccessfulSubmitTest(){
       practiceFormPage.openPage()
               .bannerClose()
               .submitForm()
               .checkFormErrorText(testData.formError);
    }

    @Test  // Отправка формы с некорректным номером телефона
    void incorrectNumberTest() {
       practiceFormPage.openPage()
               .bannerClose()
               .typeFirstName(testData.firstName)
               .typeLastName(testData.secondName)
               .typeEmail(testData.userEmail)
               .typeNumber(testData.incorrectUserNumber)
               .submitForm()
               .checkFormErrorText(testData.formError);
   }

    @Test  // Отправка формы с пустым полем First Name
    void submitWithoutNameTest() {
        practiceFormPage.openPage()
                .bannerClose()
                .typeLastName(testData.secondName)
                .typeEmail(testData.userEmail)
                .typeNumber(testData.userNumber)
                .submitForm()
                .checkFormErrorText(testData.formError);
    }
}
