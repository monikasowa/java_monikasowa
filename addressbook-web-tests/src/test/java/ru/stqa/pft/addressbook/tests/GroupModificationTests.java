package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupModificationTests extends TestBase {

    @Test

    public void testGroupModification() {


        app.getGroupsHelper().wd.findElement(By.linkText("groups")).click();
        if(!app.getGroupsHelper().isThereAGroup()){
            app.getGroupsHelper().createGroup(new GroupData("test4",null, null));
        }
        //List<GroupData> before = app.getGroupsHelper().getGroupList();

        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupForm(new GroupData("test7", "test8", "test9"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().returntoGroupPage();
        //List<GroupData> after = app.getGroupsHelper().getGroupList();
        //Assert.assertEquals(after.size(), before.size());

        //before.set(before.size() - 1,new GroupData("test7", "test8", "test9"));

        //Comparator<? super GroupData > byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
<<<<<<< HEAD
        //before.sort(byId);
<<<<<<< HEAD
<<<<<<< HEAD
        // after.sort(byId);
=======
       // before.sort(byId);
       // after.sort(byId);
        //Assert.assertEquals(before, after);

>>>>>>> parent of 34d4175... Porownanie list-usuwana grupa
=======
       // after.sort(byId);
       // Assert.assertEquals(before, after);

>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
=======
       // after.sort(byId);
       // Assert.assertEquals(before, after);

>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
    }

}





