import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class OkTest{
    private final String OK_LINK = "https://ok.ru/";
    private final String EMAIL = System.getenv("EMAIL");
    private final String PASSWORD = System.getenv("PASSWORD");
    private final String PROFILE_NAME = System.getenv("PROFILE_NAME");

    @Test
    void loginTest() {
        open(OK_LINK, OkLoginPage.class)
            .setEmail(EMAIL)
            .setPassword(PASSWORD)
            .clickLoginButton()
            .getProfileName()
            .shouldHave(text(PROFILE_NAME));
    }
}
