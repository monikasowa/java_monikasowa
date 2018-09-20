package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupMOdification() {


        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();
        if(!app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createGroup(new GroupData("test4",null, null));
        }
        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test7", "test8", "test9"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returntoGroupPage();
    }

}





