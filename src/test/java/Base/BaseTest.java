package Base;

import Pages.HomePage;
import Pages.SidebarPage;
import Pages.TextboxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

/*
Domaci:
Otici na https://demoqa.com/ sajt, zatim na elements->text box i testirati popunjavanje forme sa validnim,
nevalidnim mail-om i proveriti da li je output ispravan za svako polje
 */
public class BaseTest {

    public WebDriver driver;
    public HomePage homePage;
    public SidebarPage sidebarPage;
    public TextboxPage textboxPage;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        sidebarPage = new SidebarPage(driver);
        textboxPage = new TextboxPage(driver);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
/*
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
 */
}
