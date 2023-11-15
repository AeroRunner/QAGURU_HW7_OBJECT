package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeData {
    private final Faker fake = new Faker(new Locale("Ru"));
    private final Faker fakeEN = new Faker(new Locale("En"));

    // FOR DEMOQA Automation Practice Form
    public String
            firstName = fake.name().firstName(),
            lastName= fake.name().lastName(),
            email = fakeEN.internet().emailAddress(),
            gender = fake.options().option("Male", "Female", "Other"),
            phoneNumber = fake.phoneNumber().subscriberNumber(10),
            year = String.valueOf(fake.number().numberBetween(1970, 2000)),
            month = fake.options().option("January",
                    "February",
                    "March",
                    "April",
                    "May",
                    "June",
                    "July",
                    "August",
                    "September",
                    "October",
                    "November",
                    "December"),
            day= String.format("%02d", fake.number().numberBetween(1, 28)),
            subject = fake.options().option("Physics", "Maths", "Commerce"),
            hobby = fake.options().option("Sports", "Reading", "Music"),
            currentAddress = fake.address().fullAddress(),
            state = fake.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = randomCity(state);

    public static String randomCity(String state) {
        Faker faker = new Faker();
        switch (state) {case "Rajasthan":
            return faker.options().option("Jaipur", "Jaiselmer");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            default: return state;
        }
    }
    //FOR DEMOQA TextBox
    public String fullNameEN = fakeEN.name().fullName();
    public String adressEU = fakeEN.address().country();
    public String permAdressCity = fakeEN.address().city();

}
