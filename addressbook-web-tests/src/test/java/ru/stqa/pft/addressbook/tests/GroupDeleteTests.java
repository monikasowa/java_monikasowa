package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {

        int before = app.getGroupsHelper().getGroupCount();
        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();

        if(!app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createGroup(new GroupData("test4",null, null));
        }
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returntoGroupPage();
        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after, before -1);
    }

}
    

