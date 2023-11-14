package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.components.TCheck;

public class TextBoxTest extends BaseTest {
    TextBox textbox = new TextBox();
    UserData userData = new UserData();
    TCheck tCheck = new TCheck();
    @Test
    void trueTextBoxtest(){
        textbox.openBoxPage()
                .boxPageCheck()
                .setFullNameBox(userData.boxFullName)
                .setBoxEmail(userData.boxEmail)
                .getAddressBox(userData.boxAdress)
                .getPremAddressBox(userData.boxPremAddress)
                .submitBoxClick();

                tCheck.BoxResult(tCheck.boxName, userData.boxFullName)
                .BoxResult(tCheck.boxEmail, userData.boxEmail)
                .BoxResult(tCheck.boxAddress, userData.boxAdress)
                .BoxResult(tCheck.boxPerAddress, userData.boxPremAddress);

    }
}
