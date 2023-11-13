package pages.components;

import com.codeborne.selenide.SelenideElement;
import tests.UserData;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TCheck {

    //For DEMOQA Automation Practice Form

    UserData userData = new UserData();
    private SelenideElement
            seeModalWindow =$(".modal-dialog"),
            closeModalWindow =$("#closeLargeModal"),
            tableParagraph = $(".table-responsive");


    public String graphName = "Student Name";
    public  String graphEmail = "airplay1x6@gmail.com";
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
    public String subjects = userData.arts+", "+userData.math+", "+userData.physics;
    public String hobbies = userData.sports+", "+userData.reading+", "+ userData.music;
    public String stateAndCity = userData.state+" "+ userData.city;


    public TCheck modalSee(){
        seeModalWindow.should(appear);

        return this;
    }
    public TCheck modalClose(){
        closeModalWindow.click();
        return this;
    }
    public TCheck resultCheck(String paragraph, String value) {
        tableParagraph.$(byText(paragraph)).parent().shouldHave(text(value));
        return this;
    }

    //For DEMOQA TextBox

    private SelenideElement  resultBox = $("#output");
    public String boxCheckName = "Name:";
    public String boxCheckEmail ="Email:";
    public String boxCheckAddress = "Current Address :";
    public String boxCheckPerAddress = "Permananet Address :";
    public TCheck BoxResult(String paragraph, String value){
        resultBox.$(byText(paragraph)).parent()
                .shouldHave(text(value));
        return this;
    }

}
