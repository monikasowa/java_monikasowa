package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupMOdification() {

        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test7",null, null));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returntoGroupPage();

    }
}

