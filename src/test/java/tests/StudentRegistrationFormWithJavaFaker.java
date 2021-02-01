package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormWithJavaFaker {

//  "startMaximized" is not necessary for my objectives so it's turned off for now.
/*  @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
*/
    @Test
    void fillFormTest() {
        Faker faker = new Faker();
        FakeValueService fakeValueService = new favkeValueService(
                new locale("en-GB"), new RandomService());
        String varFirstName = faker.name().varFirstName();
        String varLastName = faker.name().varLastName();
        String varUserEmai; = fakeValuesService.bothify("????##@gmail.com");
        String varUserNumber = fakeValueService.regexify("[0-9]{10}");
        String varCurrentAddress = faker.address().varCurrentAddress();

        String varFirstName = "Stanislav",
                varLastName = "Dmitruk",
                varUserEmail = "stanislavtest@gmail.com",
                varGender = "Other",
                varUserNumber = "1234567890",
                varBirthDay = "20",
                varBirthMonth = "February",
                varBirthYear = "1991",
                varSubject1Prefix = "e",
                varSubject1Full = "Chemistry",
                varSubject2Prefix = "p",
                varSubject2Full = "Physics",
                varSubject3Prefix = "m",
                varSubject3Full = "Maths",
                varHobby1 = "Sports",
                varHobby2 = "Music",
                varPicture = "Screenshot 2020-11-20 at 02.47.53.png",
                varCurrentAddress = "Tester Strasse 123, Berlin",
                varState = "Haryana",
                varCity = "Panipat";

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").val(varFirstName);
        $("#lastName").val(varLastName);
        $("#userEmail").val(varUserEmail);
        $("#genterWrapper").$(byText(varGender)).click();
        $("#userNumber").val(varUserNumber);

//  "Set Date"
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(varBirthMonth);
        $(".react-datepicker__year-select").selectOption(varBirthYear);
        $(".react-datepicker__day--0" + varBirthDay).click();

//  "Set Subject"
        $("#subjectsInput").val(varSubject1Prefix);
        $(".subjects-auto-complete__menu-list").$(byText(varSubject1Full)).click();
        $("#subjectsInput").val(varSubject2Prefix);
        $(".subjects-auto-complete__menu-list").$(byText(varSubject2Full)).click();
        $("#subjectsInput").val(varSubject3Prefix);
        $(".subjects-auto-complete__menu-list").$(byText(varSubject3Full)).click();

        $("#hobbiesWrapper").$(byText(varHobby1)).click();
        $("#hobbiesWrapper").$(byText(varHobby2)).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/" + varPicture));
        $("#currentAddress").val(varCurrentAddress);

        $x("//div[@id='state']").scrollTo().click();
        $("#stateCity-wrapper").$(byText(varState)).click();
        $x("//div[@id='city']").click();
        $("#stateCity-wrapper").$(byText(varCity)).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(varFirstName + " " + varLastName));
        $x("//td[text()='Student Email']").parent().shouldHave(text(varUserEmail));
        $x("//td[text()='Gender']").parent().shouldHave(text(varGender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(varUserNumber));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(varBirthDay + " " + varBirthMonth + "," + varBirthYear));
        $x("//td[text()='Subjects']").parent().shouldHave(text(varSubject1Full + "," + " " + varSubject2Full + "," + " " + varSubject3Full));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(varHobby1 + "," + " " + varHobby2));
        $x("//td[text()='Picture']").parent().shouldHave(text(varPicture));
        $x("//td[text()='Address']").parent().shouldHave(text(varCurrentAddress));
        $x("//td[text()='State and City']").parent().shouldHave(text(varState + " " + varCity));

    }
}