package pages.components;

import com.codeborne.selenide.SelenideElement;
import tests.UserData;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Results {

    //For DEMOQA Automation Practice Form

    UserData userData = new UserData();
    private SelenideElement
            seeModalWindow =$(".modal-dialog"),
            closeModalWindow =$("#closeLargeModal"),
            tableParagraph = $(".table-responsive");


    public String graphName = "Student Name";
    public  String graphEmail = "Student Email";
    public String graphGender = "Gender";
    public String graphMobile = "Mobile";
    public String graphBorn = "Date of Birth";
    public String graphSubj = "Subjects";
    public String graphHobbies = "Hobbies";
    public String graphPicture = "Picture";
    public String graphAddress = "Address";
    public String graphStateCity = "State and City";
    public String fullName = userData.name+" "+userData.lastName;
    public String bornDate = userData.birthDay+" "+userData.birthMonth+","+userData.birthYear;
    public String stateAndCity = userData.state+" "+ userData.city;


    public Results modalSee(){
        seeModalWindow.should(appear);

        return this;
    }
    public Results modalClose(){
        closeModalWindow.click();
        return this;
    }
    public Results resultCheck(String paragraph, String text1) {
        tableParagraph.$(byText(paragraph)).parent().shouldHave(text(text1));
        return this;
    }

    //For DEMOQA TextBox

    private SelenideElement  resultBox = $("#output");
    public String boxName = "Name:";
    public String boxEmail ="Email:";
    public String boxAddress = "Current Address :";
    public String boxPerAddress = "Permananet Address :";
    public Results BoxResult(String paragraph, String value){
        resultBox.$(byText(paragraph)).parent()
                .shouldHave(text(value));
        return this;
    }
}
