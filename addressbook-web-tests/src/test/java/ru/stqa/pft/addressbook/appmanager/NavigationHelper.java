package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {
    public NavigationHelper(WebDriver wd) { super(wd); }


    public void groupPage() {

            if (isElementPresent(By.tagName("h1"))
                    && wd.findElements(By.tagName("h1")).toString().equals("Groups")
                    && isElementPresent(By.tagName("new"))) {
                return;
            }
            //click(By.linkText("groups"));
        wd.findElement(By.linkText("groups")).click();
        }

        public void goHome () {
            if (isElementPresent(By.id("maintable"))) {
                return;
            }
            click(By.linkText("home"));
        }
}









