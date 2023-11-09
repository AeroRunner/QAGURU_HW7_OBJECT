package tests;

import org.junit.jupiter.api.Test;
import pages.OpenConfigsForTests;
import pages.RegistrationPage;

public class RegistrPageObjectForTests extends OpenConfigsForTests {
        RegistrationPage registrationPage = new RegistrationPage();
        @Test
        void trueFullFormTest() {
            registrationPage.openFormPage()
                    .setFirstName("Dmitrii")
                    .setLastName("Elizarov")
                    .setEmail("airplay1x6@gmail.com")
                    .setGender("Male")
                    .setUserNumber("8888888888")
                    .setDateOfBirth("29", "December", "1999")
                    .setSubj("Maths","Physics","Commerce")
                    .setHobbies("Sports","Reading","Music")
                    .setImage("src/test/picture/testimage.png")
                    .setCurrAddress("Krajishka 87")
                    .setStateCity("Uttar Pradesh","Agra")
                    .clickSubmit()
                    .modalSee()
                    .checkModalResul("Student Name","Dmitrii Elizarov")
                    .checkModalResul("Student Email","airplay1x6@gmail.com")
                    .checkModalResul("Gender","Male")
                    .checkModalResul("Mobile","8888888888")
                    .checkModalResul("Date of Birth","29 December,1999")
                    .checkModalResul("Subjects","Maths, Physics, Commerce")
                    .checkModalResul("Hobbies","Sports, Reading, Music")
                    .checkModalResul("Picture","testimage.png")
                    .checkModalResul("Address","Krajishka 87")
                    .checkModalResul("State and City","Uttar Pradesh Agra")
                    .modalClose();
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

