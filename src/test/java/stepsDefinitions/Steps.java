package stepsDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pageObjects.*;

public class Steps {
    WebDriver driver;
    private AccountFragmentPage accountPage;
    private BetSlipFragmentPage betSlipPage;
    private CookiesFragmentPage cookiesPage;
    private DesktopSideBarAZFragmentPage desktopSideBarAZPage;
    private FootballCouponsFragmentPage footballCouponsPage;
    private OpenBetsFragmentPage openBetsPage;
    private PremierLeagueFragmentPage premierLeagueBettingPage;
    private SportMainPage sportMainPage;
    private SubHeaderDesktopFragmentPage subHeaderDesktopPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^I am logged-in User$")
    public void navigateToWilliamsSportPage() {
        sportMainPage = new SportMainPage(driver);
        sportMainPage.goToWilliamhillSportsPage();

        subHeaderDesktopPage = new SubHeaderDesktopFragmentPage(driver);
        subHeaderDesktopPage.changeFormatToDecimal();

        accountPage = new AccountFragmentPage(driver);
        accountPage.login(System.getProperty("username"), System.getProperty("password"));
    }

    @When("^I navigate to a Premiership football events$")
    public void gotoPremiershipFootballEvent() {
        desktopSideBarAZPage = new DesktopSideBarAZFragmentPage(driver);
        desktopSideBarAZPage.chooseFootballFromDesktopSideBar();

        cookiesPage = new CookiesFragmentPage(driver);
        cookiesPage.clickToAcceptCookies();

        footballCouponsPage = new FootballCouponsFragmentPage(driver);
        footballCouponsPage.chooseUKMatchBetting();

        premierLeagueBettingPage = new PremierLeagueFragmentPage(driver);
        premierLeagueBettingPage.chooseSomePremierLeagueBet();
    }

    @Then("^I place a bet of \"([^\"]*)\" for home team to win$")
    public void placeABetForHomeTeamToWin(String amount) {
        betSlipPage = new BetSlipFragmentPage(driver);
        betSlipPage.writeBetAmount(amount);
        betSlipPage.placeBet();
    }

    @Then("^I should get correct odds and return value for bet \"([^\"]*)\"$")
    public void checkToReturnInOpenBets(String amount) {
        openBetsPage = new OpenBetsFragmentPage(driver);
        openBetsPage.checkOpenBet(amount);
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}
