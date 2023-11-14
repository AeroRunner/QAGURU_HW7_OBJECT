package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.Results;

public class RegistrPageTest extends BaseTest {
        RegistrationPage registrationPage = new RegistrationPage();
        Results results = new Results();
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
                    .setSubj(userData.arts)
                    .setHobbies(userData.sports)
                    .setImage(userData.testImg)
                    .setCurrAddress(userData.currAddress)
                    .setStateCity(userData.state, userData.city)
                    .clickSubmit();

            results.modalSee();
            results.resultCheck(results.graphName, results.fullName)
                    .resultCheck(results.graphEmail, userData.email)
                    .resultCheck(results.graphGender, userData.gender)
                    .resultCheck(results.graphMobile, userData.number)
                    .resultCheck(results.graphBorn, results.bornDate)
                    .resultCheck(results.graphSubj, userData.arts)
                    .resultCheck(results.graphHobbies, userData.sports)
                    .resultCheck(results.graphPicture, userData.testImg)
                    .resultCheck(results.graphAddress, userData.currAddress)
                    .resultCheck(results.graphStateCity, results.stateAndCity );
            results.modalClose();
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
              results.modalSee();
              results.resultCheck(results.graphName, results.fullName )
                     .resultCheck(results.graphEmail, userData.email)
                     .resultCheck(results.graphGender, userData.gender)
                     .resultCheck(results.graphMobile, userData.number);
              results.modalClose();
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

