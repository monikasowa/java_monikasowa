package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupDeleteTests extends TestBase {

    @Test
    public void testGroupDelete() {


        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();

        if (!app.getGroupsHelper().isThereAGroup()) {
            app.getGroupsHelper().createGroup(new GroupData("test4", null, null));
        }
<<<<<<< HEAD
        List<GroupData> before = app.getGroupsHelper().getGroupList();
<<<<<<< HEAD
        app.getGroupsHelper().selectGroup(before.size() - 1);
=======
        //List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup();
>>>>>>> parent of 34d4175... Porownanie list-usuwana grupa
=======
        app.getGroupsHelper().selectGroup();
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returntoGroupPage();

        //List<GroupData> after = app.getGroupsHelper().getGroupList();
       // Assert.assertEquals(after.size(), before.size() - 1);

        //before.remove(before.size() - 1);
        //Assert.assertEquals(before, after);

    }
}





