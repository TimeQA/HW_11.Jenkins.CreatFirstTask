package tests.demoqa;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;
import static tests.demoqa.TestData.*;
import static java.lang.String.format;

public class RegistrationFormTests extends TestBase {

    RegistrationFormSearchElements registrationFormSearchElements = new RegistrationFormSearchElements();

    @Test
    @Tag("registration")
    void practiceFormTest() {

        step("Open registration form", () -> {
            registrationFormSearchElements.openPage();
        });
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        step("Fill form", () -> {
            registrationFormSearchElements
                    .setFirstName(getFirstName())
                    .setLastName(getLastName())
                    .setEmail(getEmail())
                    .setGenter(getGender())
                    .setNumber(getPhoneNumber())
                    .setBirthDate(getDay(), getMonth(), getYear())
                    .setSubjects(getSubjects())
                    .setHobbies(getHobbies())
                    .setPathFile(getPathFile())
                    .setAddress(getCurrentAddress())
                    .setState(getState())
                    .setCity(getCity())
                    .pressSubmit();
        });
        step("Checking the result form", () -> {
            String expectedFullName = format("%s %s", getFirstName(), getLastName());
            registrationFormSearchElements.checkResultVisible();
            registrationFormSearchElements.checkResult("Student Name", expectedFullName)
                    .checkResult("Student Email", getEmail())
                    .checkResult("Gender", getGender())
                    .checkResult("Mobile", getPhoneNumber())
                    .checkResult("Date of Birth", getBirthDay())
                    .checkResult("Subjects", getSubjects())
                    .checkResult("Hobbies", getHobbies())
                    .checkResult("Picture", getFileName())
                    .checkResult("Address", getCurrentAddress())
                    .checkResult("State and City", getStateAndCity());

        });

    }
}
