package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.List;

public class KontaktCreationTests extends TestBase {

    @Test
    public void testKontaktCreation()
    {
        //List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        app.getKontaktHelper().initKontaktCreation();
        app.getKontaktHelper().fillKontaktForm(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        app.getKontaktHelper().submitKontaktCreation();
        app.getKontaktHelper().returntoHomePage();

       // List<KontaktData> after = app.getKontaktHelper().getKontaktList();

        //Assert.assertEquals(after.size(), before.size()+1);

       // before.add(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
       // Assert.assertEquals(before, after);
   // }
        //app.getGroupsHelper().initGroupCreation();

    }



}


