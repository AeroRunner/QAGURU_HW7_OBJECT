package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OutputComponent {
    private SelenideElement resultBox = $("#output");
    public String boxName = "Name:";
    public String boxEmail ="Email:";
    public String boxAddress = "Current Address :";
    public String boxPerAddress = "Permananet Address :";
    public OutputComponent checkResult(String paragraph, String value){
        resultBox.$(byText(paragraph)).parent()
                .shouldHave(text(value));
        return this;
    }
}
