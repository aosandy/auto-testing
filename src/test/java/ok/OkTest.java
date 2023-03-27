package ok;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static ok.IsFirstNameAndSurname.isFirstNameAndSurname;

class OkTest{
    private static final String OK_LINK = "https://ok.ru/";
    private static final String EMAIL = "botS23AT15";
    private static final String PASSWORD = "autotests2023";
    private static final String PROFILE_NAME = "botS23AT15 botS23AT15";

    @BeforeAll
    static void beforeAll() {
        open(OK_LINK, OkLoginPage.class)
            .setEmail(EMAIL)
            .setPassword(PASSWORD)
            .clickLoginButton();
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWindow();
    }

    @Test
    void loginTest() {
        OkProfilePage profilePage = new OkProfilePage();
        profilePage.getProfileName().shouldHave(text(PROFILE_NAME));
    }

    @Test
    void toolBarSizeTest() {
        OkProfilePage profilePage = new OkProfilePage();
        ElementsCollection elements = profilePage
            .getToolBar()
            .findAll(By.cssSelector(".toolbar_nav_i"));
        assertThat(elements, hasSize(7));
    }

    @Test
    void sideBar2SizeTest() {
        OkProfilePage profilePage = new OkProfilePage();
        ElementsCollection elements = profilePage
            .getSideBar2()
            .findAll(By.cssSelector(".u-menu_li"));
        assertThat(elements, hasSize(4));
    }

    @Test
    void sideBar3SizeTest() {
        OkProfilePage profilePage = new OkProfilePage();
        ElementsCollection elements = profilePage
            .getSideBar3()
            .findAll(By.cssSelector(".u-menu_li"));
        assertThat(elements, hasSize(4));
    }

    @Test
    void sideBar2InvisibleTest() {
        OkProfilePage profilePage = new OkProfilePage();
        List<String> names = profilePage
            .getSideBar2()
            .findAll(By.cssSelector(".u-menu_li"))
            .texts();
        assertThat(names, hasItem("Невидимка"));
    }

    @Test
    void sideBar3FirstBookmarksTest() {
        OkProfilePage profilePage = new OkProfilePage();
        List<String> names = profilePage
            .getSideBar3()
            .findAll(By.cssSelector(".u-menu_li"))
            .texts();
        assertThat(names.get(0), equalTo("Закладки"));
    }

    @Test
    void sideBar3TextLengthTest() {
        OkProfilePage profilePage = new OkProfilePage();
        List<Integer> lengths = profilePage
            .getSideBar3()
            .findAll(By.cssSelector(".u-menu_li"))
            .texts()
            .stream()
            .map(String::length)
            .toList();
        assertThat(lengths, everyItem(lessThan(25)));
    }

    @Test
    void nameInUppercaseTest() {
        OkProfilePage profilePage = new OkProfilePage();
        String name = profilePage.getProfileName().getText();
        String nameInUpperCase = "BOTS23AT15 BOTS23AT15";
        assertThat(name, equalToIgnoringCase(nameInUpperCase));
    }

    @Test
    void sidebarHasItemsTest() {
        OkProfilePage profilePage = new OkProfilePage();
        List<String> names = profilePage
            .getSideBar()
            .findAll(By.cssSelector(".nav-side_i-w"))
            .texts();
        assertThat(names, hasItems("Группы", "Игры", "Приложения"));
    }

    @Test
    void ifFirstIsNameAndSurnameTest() {
        OkProfilePage profilePage = new OkProfilePage();
        List<String> names = profilePage
            .getSideBar()
            .findAll(By.cssSelector(".nav-side_i-w"))
            .texts();
        MatcherAssert.assertThat(names, isFirstNameAndSurname());
    }
}
