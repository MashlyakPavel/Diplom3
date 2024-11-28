package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver",
                String.format("%s/%s", System.getenv("WEBDRIVERS"),
                        System.getenv("YANDEX_BROWSER_DRIVER_FILENAME")));
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
        return new ChromeDriver(options);
    }

        public static WebDriver getDriver(String browser) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    // Автоматическое определение версии браузера и загрузка драйвера
                    //WebDriverManager.chromedriver().setup();
                    //return new ChromeDriver();
                    // Указанное определение версии браузера и загрузка драйвера
                    WebDriverManager.chromedriver().browserVersion("131.0.6778.86").setup();
                    return new ChromeDriver();
                case "yandex":
                    WebDriverManager.chromedriver().browserVersion("128").setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary("C:\\Users\\Anastasia\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                    return new ChromeDriver(options);
                // Для других браузеров
            /*case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();*/
                default:
                    throw new IllegalArgumentException("Unknown browser: " + browser);
            }
        }

    }