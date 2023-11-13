package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TCheck;

public class RegistrPageObjectForTests extends BaseTest {
        RegistrationPage registrationPage = new RegistrationPage();
        TCheck tCheck = new TCheck();
        UserData userData = new UserData();
        @Test
        void trueFullFormTest() {
            registrationPage.openFormPage()
                    .removeBanner()
                    .setFirstName(userData.name)
                    .setLastName(userData.lastName)
                    .setEmail(userData.email)
                    .setGender(userData.gender)
                    .setUserNumber(userData.number)
                    .setDateOfBirth(userData.birthDay, userData.birthMonth, userData.birthYear)
                    .setSubj(userData.arts, userData.math, userData.physics)
                    .setHobbies(userData.sports, userData.reading, userData.music)
                    .setImage(userData.testImg)
                    .setCurrAddress(userData.currAddress)
                    .setStateCity(userData.state, userData.city)
                    .clickSubmit();

            tCheck.modalSee();
            tCheck.resultCheck(tCheck.graphName, tCheck.fullName)
                    .resultCheck(tCheck.graphEmail, userData.email)
                    .resultCheck(tCheck.graphGender, userData.gender)
                    .resultCheck(tCheck.graphMobile, userData.number)
                    .resultCheck(tCheck.graphBorn, tCheck.bornDate)
                    .resultCheck(tCheck.graphSubj, tCheck.subjects)
                    .resultCheck(tCheck.graphHobbies, tCheck.hobbies)
                    .resultCheck(tCheck.graphPicture, userData.testImg)
                    .resultCheck(tCheck.graphAddress, userData.currAddress)
                    .resultCheck(tCheck.graphStateCity,tCheck.stateAndCity );
            tCheck.modalClose();
        }
        @Test
        void easyTrueFormTest(){
              registrationPage.openFormPage()
                    .removeBanner()
                    .setFirstName(userData.name)
                    .setLastName(userData.lastName)
                    .setEmail(userData.email)
                    .setGender(userData.gender)
                    .setUserNumber(userData.number)
                    .clickSubmit();
              tCheck.modalSee();
              tCheck.resultCheck(tCheck.graphName,tCheck.fullName )
                     .resultCheck(tCheck.graphEmail, userData.email)
                     .resultCheck(tCheck.graphGender, userData.gender)
                     .resultCheck(tCheck.graphMobile, userData.number);
              tCheck.modalClose();
        }
        @Test
        void easyFallFormtest(){
           registrationPage
                   .removeBanner()
                   .openFormPage()
                   .setFirstName(userData.name)
                   .clickSubmit();
        }
    }

