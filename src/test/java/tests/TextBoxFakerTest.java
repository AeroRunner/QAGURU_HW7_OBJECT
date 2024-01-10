package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.components.OutputComponent;
import pages.components.ResultModal;
import utils.FakeData;
@DisplayName("Class with Check Box tests via Java Faker")

public class TextBoxFakerTest extends BaseTest {
    TextBox textbox = new TextBox();
    OutputComponent resultBox = new OutputComponent();
    FakeData fake = new FakeData();
    @DisplayName("Filling and check box form with fake data")
    @Test
    void trueTextBoxtest(){
        textbox.openBoxPage()
                .boxPageCheck()
                .setFullNameBox(fake.fullNameEN)
                .setBoxEmail(fake.email)
                .getAddressBox(fake.adressEU)
                .getPremAddressBox(fake.permAdressCity)
                .submitBoxClick();

        resultBox.checkResult(resultBox.boxName, fake.fullNameEN)
                .checkResult(resultBox.boxEmail, fake.email)
                .checkResult(resultBox.boxAddress, fake.adressEU)
                .checkResult(resultBox.boxPerAddress, fake.permAdressCity);

    }
}


