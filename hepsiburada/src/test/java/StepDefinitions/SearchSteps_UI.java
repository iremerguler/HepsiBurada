package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestRunner.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchSteps_UI {

    WebDriver driver;

    @Given("Navigate to HepsiBurada web")
    public void navigate_to_hepsiburada_web() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        driver.get("https://www.hepsiburada.com/");
        driver.manage().window().maximize();
    }

    @FindBy(xpath = "//*[@id=\"SearchBoxOld\"]/div/div/div[1]/div[2]/input")
    public WebElement searchBox;
    @And("User should click on search box")
    public void user_should_click_on_search_box() {
        searchBox.click();
    }

    @And("User should enter search element {string}")
    public void user_should_enter_search_element(String searchElement) throws InterruptedException {
        searchBox.sendKeys(searchElement);
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//*[@id=\"SearchBoxOld\"]/div/div/div[2]")
    public WebElement searchButton;

    @And("User should click on search button")
    public void user_should_click_on_search_button() throws InterruptedException {
        searchButton.click();
        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebElement l=driver.findElement(By.xpath("//*[@id=\"fiyat\"]/label/div"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
    }

    @FindBy(xpath = "//*[@id=\"fiyat\"]/div/div/div/div/div[1]/div/div[1]/input")
    public WebElement enAzTextbox;

    @And("User should click on EnAz")
    public void user_should_click_on_EnAz() {
        enAzTextbox.click();
    }

    @And("User should enter min price {string}")
    public void user_should_enter_min_price(String enAz) {
        enAzTextbox.sendKeys(enAz);
    }

    @FindBy(xpath = "//*[@id=\"fiyat\"]/div/div/div/div/div[1]/div/div[2]/input")
    public WebElement enCokTextBox;

    @And("User should click on EnCok")
    public void user_should_click_on_EnCok() {
        enCokTextBox.click();
    }

    @And("User should enter max price {string}")
    public void user_should_enter_max_price(String enCok) {
        enCokTextBox.sendKeys(enCok);
    }

    @FindBy(xpath = "//*[@id=\"fiyat\"]/div/div/div/div/div[1]/button")
    public WebElement OKButton;

    @And("User should click on OK button")
    public void user_should_click_on_OK_button() throws InterruptedException {
        OKButton.click();
        Thread.sleep(5000);
    }

    @And("User should scroll down until see the item")
    public void user_should_scroll_down_until_see_the_item() {
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        WebElement e=driver.findElement(By.xpath("//*[@id=\"i3\"]/div/a/div[2]/div[1]/div[2]/div[2]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", e);
    }

    @And("User should click on an item")
    public void user_should_click_on_an_item() {
        WebElement item = driver.findElement(By.xpath("//*[@id=\"i3\"]/div/a/div[2]/div[1]/div[2]/div[2]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", item);
    }

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[3]/div/div[1]/a")
    public WebElement allButton;

    @And("User should click on Tum Saticilar")
    public void user_should_click_on_tum_saticilar() throws InterruptedException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        Thread.sleep(5000);

        allButton.click();
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//*[@id=\"merchant-list\"]/tbody/tr[1]/td[2]")
    public WebElement satici;

    @And("User should click on Satici")
    public void user_should_click_on_satici() throws InterruptedException {
        satici.click();
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//*[@id=\"merchant-list\"]/tbody/tr[1]/td[2]")
    public WebElement satici2;

    @And("User should click on Satici again")
    public void user_should_click_on_satici_again() throws InterruptedException {
        satici2.click();
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//*[@id=\"merchant-list\"]/tbody/tr[3]/td[4]/form/button")
    public WebElement addToCartButton;

    @And("User should click on Sepete Ekle of first Satici")
    public void user_should_click_on_sepeteEkle_of_firstSatici() throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(2000);
    }

    @FindBy(xpath = "//*[@id=\"pcwrapper\"]/div/a")
    public WebElement onarimPaketiIstemiyorum;

    @And("User should click on Onarım Paketi Istemiyorum")
    public void user_should_click_on_onarim_paketi_istemiyorum() throws InterruptedException {
        onarimPaketiIstemiyorum.click();
        Thread.sleep(2000);
    }

    @And("User should click on Sepetim")
    public void user_should_click_on_Sepetim(){
        WebElement item = driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()", item);

        driver.findElements(By.xpath("//*[@id=\"13368333-d843-4958-ba7c-ffc3c130e562\"]/div/div/div[1]/div[1]/figure/a/img"));
        driver.close();
    }
}
