package tests.demoqa;

import com.github.javafaker.Faker;

public class TestData {

    //                  Create faker data

    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static String currentAddress = faker.elderScrolls().quote();

    //                  filling in my data
    public static String gender = "Female";
    public static String birthDay = "05 June,1994";
    public static String day = "05";
    public static String month = "June";
    public static String year = "1994";
    public static String subjects = "Physics";
    public static String hobbies = "Sports";
    public static String pathFile = "src/test/resources/img/JSON_Momoa.jpg";
    public static String fileName = "JSON_Momoa.jpg";
    public static String state = "Haryana";
    public static String city = "Karnal";


    //                  Fills element

    public static String getFirstName() {return firstName;}
    public static String getLastName() {return lastName;}
    public static String getEmail() {return email;}
    public static String getPhoneNumber() {return phoneNumber;}
    public static String getCurrentAddress() {return currentAddress;}
    public static String getGender() {return gender;}
    public static String getBirthDay() {return birthDay;}
    public static String getDay() {return day;}
    public static String getMonth() {return month;}
    public static String getYear() {return year;}
    public static String getSubjects() {return subjects;}
    public static String getHobbies() {return hobbies;}
    public static String getPathFile() {return pathFile;}
    public static String getFileName() {return fileName;}
    public static String getState() {return state;}
    public static String getCity() {return city;}
    public static String getStateAndCity() {return String.format("%s %s", getState(), getCity());}
}
