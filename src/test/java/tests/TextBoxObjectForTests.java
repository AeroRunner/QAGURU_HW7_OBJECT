package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.components.TCheck;

public class TextBoxObjectForTests extends BaseTest {
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

                tCheck.BoxResult(tCheck.boxCheckName, userData.boxFullName)
                .BoxResult(tCheck.boxCheckEmail, userData.boxEmail)
                .BoxResult(tCheck.boxCheckAddress, userData.boxAdress)
                .BoxResult(tCheck.boxCheckPerAddress, userData.boxPremAddress);

    }
}
