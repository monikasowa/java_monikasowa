package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        //List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().fillGroupForm(new GroupData("test4", null, null));
        app.getGroupsHelper().submitGroupCreation();
        app.getGroupsHelper().returntoGroupPage();
        //List<GroupData> after = app.getGroupsHelper().getGroupList();
        //Assert.assertEquals(after.size(), before.size()+1);

        //before.add(new GroupData("test4", null, null));
       // Assert.assertEquals(before, after);
    }

}


