package tests.demoqa;
import com.codeborne.selenide.SelenideElement;
import tests.Elements.Button;
import tests.components.CalendarComponent;
import tests.components.ResultComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormSearchElements {

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultComponent resultComponent = new ResultComponent();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genterInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pathToFileInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city");
    Button submit = new Button("submit", $(byText("Submit")));

//            SelenideElement submit = $("#Submit");


    //Actions

    private final static String FIRST_TITLE_TEXT = "Student Registration Form";

    public RegistrationFormSearchElements openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FIRST_TITLE_TEXT));

        return this;
    }

    public RegistrationFormSearchElements setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormSearchElements setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormSearchElements setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormSearchElements setGenter(String value) {
        genterInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormSearchElements setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormSearchElements setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationFormSearchElements setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormSearchElements setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormSearchElements setPathFile(String value) {
        pathToFileInput.uploadFile(new File(value));

        return this;
    }

    public RegistrationFormSearchElements setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormSearchElements setState(String value) {
        $("#state").scrollTo().click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormSearchElements setCity(String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormSearchElements pressSubmit() {
        submit.click();

        return this;
    }

    // CHECK
    public RegistrationFormSearchElements checkResultVisible() {
        resultComponent.checkVisible();

        return this;
    }
    public RegistrationFormSearchElements checkResult(String key, String value) {
        resultComponent.checkResult(key, value);

        return this;
    }

}
