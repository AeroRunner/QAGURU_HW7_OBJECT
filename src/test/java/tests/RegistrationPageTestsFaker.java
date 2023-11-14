package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.TCheck;
import utils.FakeData;

public class RegistrationPageTestsFaker extends BaseTest {
    FakeData fakeData = new FakeData();
    RegistrationPage registrationPage = new RegistrationPage();
    TCheck tCheck = new TCheck();
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

        tCheck.modalSee();
        tCheck.resultCheck(tCheck.graphName, fakeData.firstName )
               .resultCheck(tCheck.graphName, fakeData.lastName)
               .resultCheck(tCheck.graphEmail, fakeData.email)
               .resultCheck(tCheck.graphGender, fakeData.gender)
               .resultCheck(tCheck.graphMobile, fakeData.phoneNumber)
               .resultCheck(tCheck.graphBorn, fakeData.day)
               .resultCheck(tCheck.graphBorn, fakeData.month)
               .resultCheck(tCheck.graphBorn, fakeData.year)
               .resultCheck(tCheck.graphSubj, fakeData.subject)
               .resultCheck(tCheck.graphSubj, fakeData.subject)
               .resultCheck(tCheck.graphHobbies, fakeData.hobbie)
               .resultCheck(tCheck.graphPicture, userData.testImg)
               .resultCheck(tCheck.graphAddress, fakeData.currentAddress)
               .resultCheck(tCheck.graphStateCity, fakeData.state )
               .resultCheck(tCheck.graphStateCity, fakeData.city);
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

