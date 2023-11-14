package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.components.Results;

public class TextBoxTest extends BaseTest {
    TextBox textbox = new TextBox();
    UserData userData = new UserData();
    Results results = new Results();
    @Test
    void trueTextBoxtest(){
        textbox.openBoxPage()
                .boxPageCheck()
                .setFullNameBox(userData.boxFullName)
                .setBoxEmail(userData.boxEmail)
                .getAddressBox(userData.boxAdress)
                .getPremAddressBox(userData.boxPremAddress)
                .submitBoxClick();

                results.BoxResult(results.boxName, userData.boxFullName)
                .BoxResult(results.boxEmail, userData.boxEmail)
                .BoxResult(results.boxAddress, userData.boxAdress)
                .BoxResult(results.boxPerAddress, userData.boxPremAddress);

    }
}
