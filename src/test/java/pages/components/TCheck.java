package pages.components;

import com.codeborne.selenide.SelenideElement;
import tests.UserData;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TCheck {
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
}
