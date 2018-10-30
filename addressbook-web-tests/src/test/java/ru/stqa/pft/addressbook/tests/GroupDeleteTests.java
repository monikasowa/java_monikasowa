package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


<<<<<<< HEAD
public class GroupDeleteTests extends TestBase

{
=======
public class GroupDeleteTests extends TestBase {
>>>>>>> parent of 801096c... Zadanie 7 - adressbook-Firefox

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
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
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before.size(), after.size());

    }
}







