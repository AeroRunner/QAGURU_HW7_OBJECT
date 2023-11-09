package tests;

import org.junit.jupiter.api.Test;
import pages.OpenConfigsForTests;
import pages.TextBox;

public class TextBoxObjectForTests extends OpenConfigsForTests {
    TextBox textbox = new TextBox();
    @Test
    void trueTextBoxtest(){
        textbox.openBoxPage()
                .boxPageCheck()
                .setFullNameBox("Dmitrii Elizarov")
                .setBoxEmail("123@gmail.com")
                .getAddressBox("Serbia")
                .getPremAddressBox("Krajishka 87 str. Belgrade")
                .submitBoxClick()
                .checkResultBox("Name:","Dmitrii Elizarov")
                .checkResultBox("Email:","123@gmail.com")
                .checkResultBox("Current Address :","Serbia")
                .checkResultBox("Permananet Address :","Krajishka 87 str. Belgrade");

    }
}
