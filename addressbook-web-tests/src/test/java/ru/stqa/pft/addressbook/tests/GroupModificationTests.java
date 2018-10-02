package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupModification() {


        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();
        if(!app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createGroup(new GroupData("test4",null, null));
        }
        List<GroupData> before = app.getGroupsHelper().getGroupList();

        app.getGroupsHelper().selectGroup(before.size() -1);
        app.getGroupsHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() -1).getId(),"test7", "test2", "test3");
        app.getGroupsHelper().fillGroupForm(group);
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        Assert.assertEquals(before, after);
        //before.set(before.size() - 1,new GroupData("test7", "test8", "test9"));

       // Comparator<? super GroupData > byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
       // before.sort(byId);
        // after.sort(byId);
    }

}
