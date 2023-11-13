package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import tests.UserData;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadFile = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            wrapperStateCity = $("#stateCity-wrapper"),
            addState = $("#state"),
            addCity =$("#city"),
            addSubmit =$("#submit");




    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage openFormPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day,month,year);

        return this;
    }
   public RegistrationPage setSubj(String subj1, String subj2, String subj3){
        subjInput.setValue(subj1).pressEnter();
       subjInput.setValue(subj2).pressEnter();
       subjInput.setValue(subj3).pressEnter();

       return this;
   }
   public RegistrationPage setHobbies(String hobbie1, String hobbie2, String hobbie3){
        hobbiesInput.$(byText(hobbie1)).click();
        hobbiesInput.$(byText(hobbie2)).click();
        hobbiesInput.$(byText(hobbie3)).click();
       return this;
   }
   public RegistrationPage setImage(String imageName){
        uploadFile.uploadFromClasspath(imageName);
    return this;
   }
   public RegistrationPage setCurrAddress(String curAddress){
        addressInput.setValue(curAddress);
        return this;
   }
   public RegistrationPage setStateCity(String state, String city){
       addState.click();
       wrapperStateCity.$(byText(state)).click();
       addCity.click();
       wrapperStateCity.$(byText(city)).click();

        return this;
   }
   public RegistrationPage clickSubmit(){
        addSubmit.click();
        return this;
   }


}
