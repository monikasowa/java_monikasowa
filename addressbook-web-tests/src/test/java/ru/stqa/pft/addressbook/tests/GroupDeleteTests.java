package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class GroupDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getGroupsHelper().goToNavigatePage();
        if(!app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createGroup(new GroupData("test4",null, null));
        }
    }
    @Test
    public void testGroupDelete() {

        List<GroupData> before = app.getGroupsHelper().getGroupList();
        int index = before.size() - 1;
        app.getGroupsHelper().selectGroup(index);
        app.getGroupsHelper().deleteSelectedGroups();
        app.getGroupsHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before.size(), after.size());

    }
}







