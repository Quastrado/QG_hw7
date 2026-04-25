package tests.testdata;

import com.github.javafaker.Faker;

public class TestDataTextBox {
    Faker faker = new Faker();

    public String userName = faker.name().fullName();
    public String userEmail = faker.internet().emailAddress();
    public String incorrectUserEmail = userEmail.replace("@", "");
    public String address = faker.address().fullAddress();
    public String expectedName = "Name:" + userName;
    public String expectedEmail = "Email:" + userEmail;
    public String expectedCurrentAddress = "Current Address :" + address;
    public String expectedPermanentAddress = "Permananet Address :" + address;
}
