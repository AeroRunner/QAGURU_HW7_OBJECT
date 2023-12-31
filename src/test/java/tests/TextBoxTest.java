package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;
import pages.UserData;
import pages.components.OutputComponent;

public class TextBoxTest extends BaseTest {
    TextBox textbox = new TextBox();
    UserData userData = new UserData();
    OutputComponent outputComponent = new OutputComponent();
    @Test
    void trueTextBoxtest(){
        textbox.openBoxPage()
                .boxPageCheck()
                .setFullNameBox(userData.boxFullName)
                .setBoxEmail(userData.boxEmail)
                .getAddressBox(userData.boxAdress)
                .getPremAddressBox(userData.boxPremAddress)
                .submitBoxClick();

                outputComponent.checkResult(outputComponent.boxName, userData.boxFullName)
                .checkResult(outputComponent.boxEmail, userData.boxEmail)
                .checkResult(outputComponent.boxAddress, userData.boxAdress)
                .checkResult(outputComponent.boxPerAddress, userData.boxPremAddress);

    }
}
