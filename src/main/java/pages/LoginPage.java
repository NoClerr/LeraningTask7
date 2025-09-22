package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static java.nio.channels.Selector.open;

public class LoginPage {

    private final SelenideElement usernameField = $("[data-qa-id='login_email_input']");
    private final SelenideElement passwordField = $("[data-qa-id='login_password_input']");
    private final SelenideElement loginButton = $("[data-qa-id='login_submit_button']");

    @Step("Открываем страницу авторизации")
    public LoginPage OpenAuthPage() {
        Selenide.open("/login");;
        return this;
    }
    @Step("Заполняем поле email")
    public LoginPage setUsername(String username) {
        usernameField.shouldBe(visible).setValue(username);
        return this;
    }

    @Step("Заполняем поле пароль")
    public LoginPage setPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
        return this;
    }

    @Step("Кликаем по кнопке вход")
    public LoginPage clickLogin() {
        loginButton.shouldBe(visible).click();
        return this;
    }
}