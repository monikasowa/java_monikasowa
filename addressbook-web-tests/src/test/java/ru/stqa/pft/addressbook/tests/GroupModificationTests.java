package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupMOdification() {

        int before = app.getGroupsHelper().getGroupCount();
        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();
        if(!app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createGroup(new GroupData("test4",null, null));
        }
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test7", "test8", "test9"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returntoGroupPage();
        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }

}





