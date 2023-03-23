package ok;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ok.IsFirstNameAndSurname.isFirstNameAndSurname;

class OkTest{
    private final String OK_LINK = "https://ok.ru/";
    private final String EMAIL = "botS23AT15";
    private final String PASSWORD = "autotests2023";
    private final String PROFILE_NAME = "botS23AT15 botS23AT15";

    @Test
    void loginTest() {
        open(OK_LINK, OkLoginPage.class)
            .setEmail(EMAIL)
            .setPassword(PASSWORD)
            .clickLoginButton()
            .getProfileName()
            .shouldHave(text(PROFILE_NAME));
    }

    @Test
    void nameInUppercaseTest() {
        String name = open(OK_LINK, OkLoginPage.class)
            .setEmail(EMAIL)
            .setPassword(PASSWORD)
            .clickLoginButton()
            .getProfileName()
            .getText();
        String nameInUpperCase = "BOTS23AT15 BOTS23AT15";
        assertThat(name, equalToIgnoringCase(nameInUpperCase));
    }

    @Test
    void sidebarHasItemsTest() {
        List<String> names = open(OK_LINK, OkLoginPage.class)
            .setEmail(EMAIL)
            .setPassword(PASSWORD)
            .clickLoginButton()
            .getSideBar()
            .findAll(By.cssSelector(".nav-side_i-w"))
            .texts();
        assertThat(names, hasItems("Группы", "Игры", "Приложения"));
    }

    @Test
    void ifFirstIsNameAndSurnameTest() {
        List<String> names = open(OK_LINK, OkLoginPage.class)
            .setEmail(EMAIL)
            .setPassword(PASSWORD)
            .clickLoginButton()
            .getSideBar()
            .findAll(By.cssSelector(".nav-side_i-w"))
            .texts();
        MatcherAssert.assertThat(names, isFirstNameAndSurname());
    }
}
