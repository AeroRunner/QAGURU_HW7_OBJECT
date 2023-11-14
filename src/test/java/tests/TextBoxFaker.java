package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.components.Results;
import utils.FakeData;

public class TextBoxFaker extends BaseTest {
    TextBox textbox = new TextBox();
    Results results = new Results();
    FakeData fake = new FakeData();
    @Test
    void trueTextBoxtest(){
        textbox.openBoxPage()
                .boxPageCheck()
                .setFullNameBox(fake.fullNameEN)
                .setBoxEmail(fake.email)
                .getAddressBox(fake.adressEU)
                .getPremAddressBox(fake.permAdressCity)
                .submitBoxClick();

        results.BoxResult(results.boxName, fake.fullNameEN)
                .BoxResult(results.boxEmail, fake.email)
                .BoxResult(results.boxAddress, fake.adressEU)
                .BoxResult(results.boxPerAddress, fake.permAdressCity);

    }
}


