package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    private SelenideElement
    checkBoxPage = $(".main-header"),
    fullnameBox = $("#userName"),
    emailBox = $("#userEmail"),
    addressBox = $("#currentAddress"),
    premantAddressBox = $("#permanentAddress"),
    pressSubmitBox = $ ("#submit");


    public TextBox openBoxPage(){
     open("/text-box");
     return this;
    }
    public TextBox boxPageCheck(){
        checkBoxPage.shouldHave(text("Text Box"));
        return this;
    }
    public TextBox setFullNameBox(String value){
        fullnameBox.setValue(value);
        return this;
    }
    public TextBox setBoxEmail(String value){
        emailBox.setValue(value);
        return this;
    }
    public TextBox getAddressBox(String value){
        addressBox.setValue(value);
        return this;
    }
    public TextBox getPremAddressBox(String value){
        premantAddressBox.setValue(value);
        return this;
    }
    public TextBox submitBoxClick(){
        pressSubmitBox.click();
        return this;
    }
}
