package pageObjects;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class StaleElement {

    public static void clickStaleElement(WebElement element) {
        try {
            element.click();
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
    }
}
