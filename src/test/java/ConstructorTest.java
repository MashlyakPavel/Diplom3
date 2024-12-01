import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;

import static drivers.Driver.getDriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Указываем браузер через параметр, например "chrome" или "yandex"
        String browser = System.getProperty("browser", "chrome");
        driver = getDriver(browser);
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    @Test
    @DisplayName("Перейти к разделу о соусах")
    public void successPassToSaucesChapter() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickSaucesChapter();
        assertTrue("Заголовок раздела о соусах не отображается", objMainPage.saucesHeaderIsVisible());
        assertTrue("Вкладка 'Соусы' не активна", objMainPage.isSaucesTabActive());
    }

    @Test
    @DisplayName("Перейти к разделу о начинках")
    public void successPassToFillingsChapter() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickFillingsChapter();
        assertTrue("Заголовок раздела о начинках не отображается", objMainPage.fillingsHeaderIsVisible());
    }

    @Test
    @DisplayName("Перейти к разделу о булочках")
    public void successPassToBunsChapter() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.open();
        objMainPage.clickFillingsChapter();
        objMainPage.clickBunsChapter();
        assertTrue("Заголовок раздела о булочках не отображается", objMainPage.bunsHeaderIsVisible());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}