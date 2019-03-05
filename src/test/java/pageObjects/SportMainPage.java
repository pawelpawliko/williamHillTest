package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SportMainPage {

    WebDriver driver;
    private static final String WILLIAMHILL_SPORTS_URL = "https://sports.williamhill.com/betting/en-gb";

    public SportMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToWilliamhillSportsPage() {
        driver.get(WILLIAMHILL_SPORTS_URL);
    }
}
