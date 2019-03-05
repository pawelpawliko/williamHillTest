package pageObjects;

import org.openqa.selenium.WebElement;

public class StaleElement {

    /* for loop used for stale element
       because Webdriver wait doesn't work
     */
    public static void clickStaleElement(WebElement element) {
        for (int i = 0; i <= 2; i++) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
