package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public SessionHelper sessionHelper;
    public GroupsHelper groupsHelper;
    public KontaktHelper kontaktHelper;
    public NavigationHelper navigationHelper;
    public String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }



    public void init() {

        if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        } else if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.IE) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupsHelper = new GroupsHelper(wd);
        kontaktHelper = new KontaktHelper(wd);
        sessionHelper = new SessionHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper.Login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupsHelper group() {
        return groupsHelper;
    }

    public NavigationHelper goTo(){
        return navigationHelper;

    }
    public KontaktHelper kontakt() {
        return kontaktHelper;
    }
    public NavigationHelper goHome() {
        return navigationHelper;
    }

}