package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationPage {

    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail");

    public void firstNameSet(String text) {
        firstNameInput.val(text);
    }

    public void lastNameSet(String text) {
        lastNameInput.val(text);
    }

    public void userEmailSet(String text) {
        userEmailInput.val(text);
    }

    public void baseInfoSet(String varFirstName, String varLastName, String varUserEmail) {
//        firstNameInput.val(varFirstName);
//        lastNameInput.val(varLastName);
//        userEmailInput.val(varUserEmail);

        firstNameSet(varFirstName);
        lastNameSet(varLastName);
        userEmailSet(varUserEmail);
    }
}
