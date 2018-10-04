import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class test {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void test() {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys("\\undefined");
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
        if (!wd.findElement(By.id("51")).isSelected()) {
            wd.findElement(By.id("51")).click();
        }
        wd.findElement(By.xpath("//table[@id='maintable']//td[.='Sowa']")).click();
        wd.findElement(By.xpath("//table[@id='maintable']//td[.='Basia']")).click();
        if (!wd.findElement(By.id("52")).isSelected()) {
            wd.findElement(By.id("52")).click();
        }
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[2]")).click();
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[3]")).click();
        if (!wd.findElement(By.id("53")).isSelected()) {
            wd.findElement(By.id("53")).click();
        }
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[2]")).click();
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[4]/td[3]")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
