import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class OkProfilePage {
    private final By PROFILE_NAME = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");

    public SelenideElement getProfileName() {
        return $(PROFILE_NAME);
    }
}
