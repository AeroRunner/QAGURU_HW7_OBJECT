package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModal;
import pages.UserData;

public class RegistrationPageTest extends BaseTest {
        RegistrationPage registrationPage = new RegistrationPage();
        ResultModal resultModal = new ResultModal();
        UserData userData = new UserData();
        @Test
        void trueFullFormTest() {
            registrationPage.openFormPage()
                    .removeBanner()
                    .setFirstName(userData.name)
                    .setLastName(userData.lastName)
                    .setEmail(userData.email)
                    .choiceGender(userData.gender)
                    .setUserNumber(userData.number)
                    .choiceDateOfBirth(userData.birthDay, userData.birthMonth, userData.birthYear)
                    .setSubj(userData.arts)
                    .choiceHobby(userData.sports)
                    .uploadImage(userData.testImg)
                    .setCurrAddress(userData.currAddress)
                    .choiceStateCity(userData.state, userData.city)
                    .clickSubmit();

            resultModal.verifyModalAppeared();
            resultModal.checkResult(resultModal.graphName, resultModal.fullName)
                    .checkResult(resultModal.graphEmail, userData.email)
                    .checkResult(resultModal.graphGender, userData.gender)
                    .checkResult(resultModal.graphMobile, userData.number)
                    .checkResult(resultModal.graphBorn, resultModal.bornDate)
                    .checkResult(resultModal.graphSubj, userData.arts)
                    .checkResult(resultModal.graphHobby, userData.sports)
                    .checkResult(resultModal.graphPicture, userData.testImg)
                    .checkResult(resultModal.graphAddress, userData.currAddress)
                    .checkResult(resultModal.graphStateCity, resultModal.stateAndCity );
        }
        @Test
        void easyTrueFormTest(){
              registrationPage.openFormPage()
                    .removeBanner()
                    .setFirstName(userData.name)
                    .setLastName(userData.lastName)
                    .setEmail(userData.email)
                    .choiceGender(userData.gender)
                    .setUserNumber(userData.number)
                    .clickSubmit();
              resultModal.verifyModalAppeared();
              resultModal.checkResult(resultModal.graphName, resultModal.fullName )
                     .checkResult(resultModal.graphEmail, userData.email)
                     .checkResult(resultModal.graphGender, userData.gender)
                     .checkResult(resultModal.graphMobile, userData.number);
        }
        @Test
        void easyFallFormtest(){
           registrationPage.openFormPage()
                   .removeBanner()
                   .setFirstName(userData.name)
                   .clickSubmit()
                   .checkTableHidden();
        }
    }

