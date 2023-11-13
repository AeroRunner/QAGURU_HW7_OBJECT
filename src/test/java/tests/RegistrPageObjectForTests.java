package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TCheck;

public class RegistrPageObjectForTests extends BaseTest {
        RegistrationPage registrationPage = new RegistrationPage();
        TCheck tCheck = new TCheck();
        UserData userData = new UserData();
        private String fullName = userData.name+" "+userData.lastName;
        private String bornDate = userData.birthDay+" "+userData.birthMonth+","+userData.birthYear;
        private String subjects = userData.arts+", "+userData.math+", "+userData.physics;
        private String hobbies = userData.sports+", "+userData.reading+", "+ userData.music;
        String stateAndCity = userData.state+" "+ userData.city;

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
            tCheck.resultCheck(tCheck.graphName, fullName)
                    .resultCheck(tCheck.graphEmail, userData.email)
                    .resultCheck(tCheck.graphGender, userData.gender)
                    .resultCheck(tCheck.graphMobile, userData.number)
                    .resultCheck(tCheck.graphBorn, bornDate)
                    .resultCheck(tCheck.graphSubj, subjects)
                    .resultCheck(tCheck.graphHobbies, hobbies)
                    .resultCheck(tCheck.graphPicture, userData.testImg)
                    .resultCheck(tCheck.graphAddress, userData.currAddress)
                    .resultCheck(tCheck.graphStateCity, stateAndCity);
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
              tCheck.resultCheck(tCheck.graphName,fullName )
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

