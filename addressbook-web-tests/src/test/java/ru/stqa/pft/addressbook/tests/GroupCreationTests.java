package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        int before = app.getGroupsHelper().getGroupCount();
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().fillGroupForm(new GroupData("test4", null, null));
        app.getGroupsHelper().submitGroupCreation();
        app.getGroupsHelper().returntoGroupPage();
        int after = app.getGroupsHelper().getGroupCount();
        Assert.assertEquals(after, before+1);
    }

}


