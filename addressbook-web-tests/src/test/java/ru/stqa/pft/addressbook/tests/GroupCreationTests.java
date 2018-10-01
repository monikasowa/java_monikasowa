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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
=======
        //before.add(new GroupData("test4", null, null));
       // Assert.assertEquals(before, after);
>>>>>>> parent of 34d4175... Porownanie list-usuwana grupa
=======
        //before.add(new GroupData("test4", null, null));
        //Assert.assertEquals(before, after);
        //  }

>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
=======
        //before.add(new GroupData("test4", null, null));
        //Assert.assertEquals(before, after);
        //  }

>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
    }

}

