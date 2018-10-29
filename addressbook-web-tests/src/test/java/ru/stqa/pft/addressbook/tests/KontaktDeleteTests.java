package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.List;

public class KontaktDeleteTests extends TestBase

{

    @BeforeMethod
    public void ensurePreconditions() {
        app.getKontaktHelper().gotoMainPage();
        if (!app.getKontaktHelper().isThereAKontakt()) {
            app.getKontaktHelper().createKontakt(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        }
    }
    @Test
    public void testKontaktDelete()

    {

        List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        KontaktData k = before.get(before.size() - 1);
        int index = before.size() - 1;
        int id_k = k.getId();
        String id_s = Integer.toString(id_k);
        app.getKontaktHelper().selectKontakt(index);
        app.getKontaktHelper().deleteSelectedKontakts();
        app.getKontaktHelper().returntoHomePage();
        List<KontaktData> after = app.getKontaktHelper().getKontaktList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }

}
