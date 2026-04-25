package tests.testdata;

import com.github.javafaker.Faker;
import utils.RandomUtils;

public class TestDataPracticeForm {
    Faker faker = new Faker();

    public String subtitleText = "Student Registration Form";
    public String firstName = faker.name().firstName();
    public String secondName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String genderTextValue = RandomUtils.getRandomGender();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String dateDay = String.format("%02d", faker.number().numberBetween(1, 28));;
    public String dateMonth = faker.options().option(
            "January",
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
            "December"
    );
    public String dateMonthNumber = switch (dateMonth) {
        case "January" -> "01";
        case "February" -> "02";
        case "March" -> "03";
        case "April" -> "04";
        case "May" -> "05";
        case "June" -> "06";
        case "July" -> "07";
        case "August" -> "08";
        case "September" -> "09";
        case "October" -> "10";
        case "November" -> "11";
        case "December" -> "12";
        default -> "01";
    };
    public String dateYear = String.valueOf(faker.number().numberBetween(1900, 2100));
    public String dateOfBirth = String.format("%s-%s-%s", dateYear, dateMonthNumber, dateDay);
    public String subject = faker.options().option(
            "Maths",
            "Chemistry",
            "Computer Science",
            "Civis",
            "Arts",
            "History",
            "Biology",
            "Physics",
            "Economics",
            "English"
    );
    public String hobbie = faker.options().option("Sports", "Reading", "Music");
    public String uploadPicture = "capybara.avif";
    public String currentAddress = "Pushkina, Kolotushkina";
    public String state = faker.options().option(
            "NCR",
            "Uttar Pradesh",
            "Haryana"
    );
    public String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> "Delhi";
    };
    public String successSubmitText = "Thanks for submitting the form";
    public String formError = "Please fill required fields and enter a valid 10-digit mobile number.";
    public String incorrectUserNumber = faker.phoneNumber().subscriberNumber(3);
}
