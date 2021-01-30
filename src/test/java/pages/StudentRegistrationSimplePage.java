package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationSimplePage {

    public void firstNameSet(String text) {
        $("#firstName").val(text);
    }

    public void lastNameSet(String text) {
        $("#lastName").val(text);
    }

    public void userEmailSet(String text) {
        $("#userEmail").val(text);
    }

}
