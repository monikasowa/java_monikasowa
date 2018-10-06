package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.List;

public class KontaktDeleteTests extends TestBase{


    @Test
    public void testKontaktDelete() {


        app.getKontaktHelper().gotoMainPage();

        if (!app.getKontaktHelper().isThereAKontakt())
        {
            app.getKontaktHelper().createKontakt(new KontaktData("Monika","Sowka","null", "null","null", "null", "null", "null" , "null"  ));
        }
        List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        KontaktData k = before.get(before.size()-1);
        int id_k = k.getId();
        String id_s = Integer.toString(id_k);
        app.getKontaktHelper().selectKontakt(id_s);
        app.getKontaktHelper().deleteSelectedKontakts();
        app.getKontaktHelper().returntoHomePage();
        List<KontaktData> after = app.getKontaktHelper().getKontaktList();
        Assert.assertEquals(after.size(), before.size()-1 );


        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}
