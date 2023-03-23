package ok;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class OkLoginPage {

    private final By FIELD_EMAIL = By.id("field_email");
    private final By FIELD_PASSWORD = By.id("field_password");
    private final By LOGIN_BUTTON = By.cssSelector(".button-pro.__wide");

    public OkLoginPage setEmail(String email) {
        $(FIELD_EMAIL).val(email);
        return this;
    }

    public OkLoginPage setPassword(String password) {
        $(FIELD_PASSWORD).val(password);
        return this;
    }

    public OkProfilePage clickLoginButton() {
        $(LOGIN_BUTTON).click();
        return page(OkProfilePage.class);
    }
}
