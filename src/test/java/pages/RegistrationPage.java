package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

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
            addState = $("#react-select-3-input"),
            addCity =$("#react-select-4-input"),
            addSubmit =$("#submit"),
            seeModalWindow =$(".modal-dialog"),
            closeModalWindow =$("#closeLargeModal"),
            tableParagraph = $(".table-responsive");



    CalendarComponent calendarComponent = new CalendarComponent();

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
        calendarComponent.setDate(day, month, year);

        return this;
    }
   public RegistrationPage setSubj(String subject1,String subject2,String subject3){
        subjInput.setValue(subject1).pressEnter();
       subjInput.setValue(subject2).pressEnter();
       subjInput.setValue(subject3).pressEnter();

       return this;
   }
   public RegistrationPage setHobbies(String hobbie1,String hobbie2,String hobbie3){
        hobbiesInput.$(byText(hobbie1)).click();
        hobbiesInput.$(byText(hobbie2)).click();
        hobbiesInput.$(byText(hobbie3)).click();
       return this;
   }
   public RegistrationPage setImage(String imageName){
        uploadFile.uploadFile(new File(imageName));
    return this;
   }
   public RegistrationPage setCurrAddress(String curAddress){
        addressInput.setValue(curAddress);
        return this;
   }
   public RegistrationPage setStateCity(String state, String city){
        addState.setValue(state).pressEnter();
        addCity.setValue(city).pressEnter();
        return this;
   }
   public RegistrationPage clickSubmit(){
        addSubmit.click();
        return this;
   }
   public RegistrationPage modalSee(){
        seeModalWindow.should(appear);
        return this;
   }
   public RegistrationPage modalClose(){
        closeModalWindow.click();
        return this;
   }
    public RegistrationPage checkModalResul(String paragraph, String value) {
        tableParagraph.$(byText(paragraph)).parent()
                .shouldHave(text(value));

        return this;
    }

}
