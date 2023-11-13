package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultModalComponent;

public class RegistrPageObjectForTests extends BaseTest {
        RegistrationPage registrationPage = new RegistrationPage();
        ResultModalComponent resultModalComponent = new ResultModalComponent();
        UserData userData = new UserData();
    String [] paramName= {"Student Name", "Student Email", "Gender", "Mobile",
            "Date of Birth", "Subjects", "Hobbies", "Picture", "Address", "State and City"};
    String [] expected = {userData.name + " " + "Elizarov", "airplay1x6@gmail.com", "Male", "8888888888",
            "29"+" "+"December"+","+"1999", String.join(", ","Maths, Physics, Commerce"),
            String.join(", ", "Sports","Reading","Music"), "testimage.png", "Krajishka 87", "Uttar Pradesh" + " " + "Agra"};
        @Test
        void trueFullFormTest() {
            registrationPage.openFormPage()
                    .setFirstName(userData.name)
                    .setLastName("Elizarov")
                    .setEmail("airplay1x6@gmail.com")
                    .setGender("Male")
                    .setUserNumber("8888888888")
                    .setDateOfBirth("29", "December", "1999")
                    .setSubj("Maths","Physics","Commerce")
                    .setHobbies("Sports","Reading","Music")
                    .setImage("testimage.png")
                    .setCurrAddress("Krajishka 87")
                    .setStateCity("Uttar Pradesh","Agra")
                    .clickSubmit()
                    .modalSee();
            resultModalComponent.checkResult(paramName, expected);
//                    .checkModalResul("Student Name","Dmitrii Elizarov")
//                    .checkModalResul("Student Email","airplay1x6@gmail.com")
//                    .checkModalResul("Gender","Male")
//                    .checkModalResul("Mobile","8888888888")
//                    .checkModalResul("Date of Birth","15 December,1999")
//                    .checkModalResul("Subjects","Maths, Physics, Commerce")
//                    .checkModalResul("Hobbies","Sports, Reading, Music")
//                    .checkModalResul("Picture","testimage.png")
//                    .checkModalResul("Address","Krajishka 87")
//                    .checkModalResul("State and City","Uttar Pradesh Agra")

        }
        @Test
        void easyTrueFormTest(){
              registrationPage.openFormPage()
                    .setFirstName("Kate")
                    .setLastName("Wick")
                    .setEmail("katew@gmail.com")
                    .setGender("Other")
                    .setUserNumber("0123456789")
                    .clickSubmit()
                    .checkModalResul("Student Name","Kate Wick")
                    .checkModalResul("Student Email","katew@gmail.com")
                    .checkModalResul("Gender","Other")
                    .checkModalResul("Mobile","0123456789")
                    .modalClose();

        }
        @Test
        void easyFallFormtest(){
           registrationPage.openFormPage()
                   .setFirstName("Arkadiy")
                   .clickSubmit()
                   .modalSee();
        }
    }

