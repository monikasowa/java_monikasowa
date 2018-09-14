package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;
import org.openqa.selenium.*;


public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {

        wd.findElement(By.linkText("groups")).click();
        selectGroup();
        deleteSelectedGroups();
        returntoGroupPage();
    }

}
    

