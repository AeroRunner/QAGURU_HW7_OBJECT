package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.Results;
import utils.FakeData;

public class RegistrationPageTestsFaker extends BaseTest {
    FakeData fakeData = new FakeData();
    RegistrationPage registrationPage = new RegistrationPage();
    Results results = new Results();
    UserData userData = new UserData();
    @Test
    void trueFullFormTest() {
        registrationPage.openFormPage()
                .removeBanner()
                .setFirstName(fakeData.firstName)
                .setLastName(fakeData.lastName)
                .setEmail(fakeData.email)
                .setGender(fakeData.gender)
                .setUserNumber(fakeData.phoneNumber)
                .setDateOfBirth(fakeData.day, fakeData.month, fakeData.year)
                .setSubj(fakeData.subject)
                .setHobbies(fakeData.hobbie)
                .setImage(userData.testImg)
                .setCurrAddress(fakeData.currentAddress)
                .setStateCity(fakeData.state, fakeData.city)
                .clickSubmit();

        results.modalSee();
        results.resultCheck(results.graphName, fakeData.firstName )
               .resultCheck(results.graphName, fakeData.lastName)
               .resultCheck(results.graphEmail, fakeData.email)
               .resultCheck(results.graphGender, fakeData.gender)
               .resultCheck(results.graphMobile, fakeData.phoneNumber)
               .resultCheck(results.graphBorn, fakeData.day)
               .resultCheck(results.graphBorn, fakeData.month)
               .resultCheck(results.graphBorn, fakeData.year)
               .resultCheck(results.graphSubj, fakeData.subject)
               .resultCheck(results.graphSubj, fakeData.subject)
               .resultCheck(results.graphHobbies, fakeData.hobbie)
               .resultCheck(results.graphPicture, userData.testImg)
               .resultCheck(results.graphAddress, fakeData.currentAddress)
               .resultCheck(results.graphStateCity, fakeData.state )
               .resultCheck(results.graphStateCity, fakeData.city);
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

