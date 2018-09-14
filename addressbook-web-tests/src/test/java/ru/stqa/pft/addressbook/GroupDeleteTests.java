package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import org.openqa.selenium.*;


public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {
      
        wd.findElement(By.linkText("groups")).click();
        wd.findElement(By.name("selected[]")).click();
        wd.findElement(By.name("delete")).click();
        wd.findElement(By.linkText("group page")).click();
    }
}
    

