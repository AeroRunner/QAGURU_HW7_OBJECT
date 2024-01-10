package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModal;
import utils.FakeData;
import pages.UserData;
@DisplayName("Class with form tests via jAVA FAKER")
public class RegistrationPageFakerTest extends BaseTest {
    FakeData fake = new FakeData();
    RegistrationPage registrationPage = new RegistrationPage();
    ResultModal resultModal = new ResultModal();
    UserData userData = new UserData();

    @Test
    @DisplayName("Filling out the form with fake data")
    void trueFullFormFakerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openFormPage()
                .removeBanner()
                .setFirstName(fake.firstName)
                .setLastName(fake.lastName)
                .setEmail(fake.email)
                .choiceGender(fake.gender)
                .setUserNumber(fake.phoneNumber)
                .choiceDateOfBirth(fake.day, fake.month, fake.year)
                .setSubj(fake.subject)
                .choiceHobby(fake.hobby)
                .uploadImage(userData.testImg)
                .setCurrAddress(fake.currentAddress)
                .choiceStateCity(fake.state, fake.city)
                .clickSubmit();

        resultModal.verifyModalAppeared();
        resultModal.checkResult(resultModal.graphName, fake.firstName +" "+fake.lastName )
                .checkResult(resultModal.graphEmail, fake.email)
                .checkResult(resultModal.graphGender, fake.gender)
                .checkResult(resultModal.graphMobile, fake.phoneNumber)
                .checkResult(resultModal.graphBorn, fake.day+" "+fake.month+","+fake.year)
                .checkResult(resultModal.graphSubj, fake.subject)
                .checkResult(resultModal.graphHobby, fake.hobby)
                .checkResult(resultModal.graphPicture, userData.testImg)
                .checkResult(resultModal.graphAddress, fake.currentAddress)
                .checkResult(resultModal.graphStateCity, fake.state+" "+fake.city );
    }
    @Test
    @DisplayName("Checking a form with fake data")
    void easyTrueFormFakerTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage.openFormPage()
                .removeBanner()
                .setFirstName(fake.firstName)
                .setLastName(fake.lastName)
                .setEmail(fake.email)
                .choiceGender(fake.gender)
                .setUserNumber(fake.phoneNumber)
                .clickSubmit();
        resultModal.verifyModalAppeared();
        resultModal.checkResult(resultModal.graphName, fake.firstName+" "+fake.lastName )
                .checkResult(resultModal.graphEmail, fake.email)
                .checkResult(resultModal.graphGender, fake.gender)
                .checkResult(resultModal.graphMobile, fake.phoneNumber);
    }
    @Test
    @DisplayName("Negative test with fake data")
    void negativeFormFakerTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationPage
                .openFormPage()
                .removeBanner()
                .setFirstName(fake.fullNameEN)
                .clickSubmit()
                .checkTableHidden();
    }
}

