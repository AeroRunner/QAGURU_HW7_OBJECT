package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.components.TCheck;
import utils.FakeData;

public class TextBoxFaker extends BaseTest {
    TextBox textbox = new TextBox();
    TCheck tCheck = new TCheck();
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

        tCheck.BoxResult(tCheck.boxName, fake.fullNameEN)
                .BoxResult(tCheck.boxEmail, fake.email)
                .BoxResult(tCheck.boxAddress, fake.adressEU)
                .BoxResult(tCheck.boxPerAddress, fake.permAdressCity);

    }
}


