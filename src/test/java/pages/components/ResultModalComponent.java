package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {
    private SelenideElement reusltModalForm = $("tbody");

    public void checkResult(String[] paramName, String[] paramResult) {
        for (int i = 0; i < paramResult.length; i++) {
            reusltModalForm.$(byText(paramName[i])).sibling(0).shouldHave(text(paramResult[i]));
        }
    }
}
