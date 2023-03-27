package ok;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkProfilePage {
    private final By PROFILE_NAME = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");
    private final By SIDE_BAR = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div");
    private final By SIDE_BAR_2 = By.xpath("//*[@id=\"hook_Block_LeftColumnTopCard\"]");
    private final By SIDE_BAR_3 = By.xpath("//*[@id=\"hook_Block_LeftColumnThirdMenuSection\"]");
    private final By TOOL_BAR = By.xpath("//*[@id=\"topPanel\"]/div/div[1]/div/nav/ul");

    public SelenideElement getProfileName() {
        return $(PROFILE_NAME);
    }

    public SelenideElement getSideBar() {
        return $(SIDE_BAR);
    }

    public SelenideElement getSideBar2() {
        return $(SIDE_BAR_2);
    }

    public SelenideElement getSideBar3() {
        return $(SIDE_BAR_3);
    }

    public SelenideElement getToolBar() {
        return $(TOOL_BAR);
    }
}
