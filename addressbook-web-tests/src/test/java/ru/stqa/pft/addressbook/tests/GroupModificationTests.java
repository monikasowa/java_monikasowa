package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupMOdification() {


        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();
        if(!app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createGroup(new GroupData("test4",null, null));
        }
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test7", "test8", "test9"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());
    }

}





