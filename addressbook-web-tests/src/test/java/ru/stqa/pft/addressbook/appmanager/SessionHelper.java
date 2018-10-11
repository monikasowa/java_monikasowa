package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends BaseHelper{


    public SessionHelper(WebDriver wd) {

        super(wd);
    }

    public void Login(String username, String password) {

        type((By.name("user")),(username));
        type((By.name("pass")),(password));
        wd.findElement(By.name("pass")).click();

        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}


