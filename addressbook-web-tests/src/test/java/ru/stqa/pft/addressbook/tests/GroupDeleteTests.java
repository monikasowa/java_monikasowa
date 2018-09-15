package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.*;


public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {

        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returntoGroupPage();
    }

}
    

