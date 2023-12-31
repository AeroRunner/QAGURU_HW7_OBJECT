package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModal;
import utils.FakeData;
import pages.UserData;

public class RegistrationPageFakerTest extends BaseTest {
    FakeData fake = new FakeData();
    RegistrationPage registrationPage = new RegistrationPage();
    ResultModal resultModal = new ResultModal();
    UserData userData = new UserData();

    @Test
    void trueFullFormFakerTest() {
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
    void easyTrueFormFakerTest(){
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
    void negativeFormFakerTest(){
        registrationPage
                .openFormPage()
                .removeBanner()
                .setFirstName(fake.fullNameEN)
                .clickSubmit()
                .checkTableHidden();
    }
}

