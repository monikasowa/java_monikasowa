package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.Comparator;
import java.util.List;

public class KontaktModificationTests extends TestBase{
    @Test

    public void testKontaktModification() {


        List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        app.getKontaktHelper().gotoMainPage();
        if (!app.getKontaktHelper().isThereAKontakt()) {
            app.getKontaktHelper().createKontakt(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        }
        app.getKontaktHelper().selectKontakt(before.size()-1);
        app.getKontaktHelper().initKontaktModification();
        KontaktData kontakt = new KontaktData(before.get(before.size() - 1).getId(), "Kasia", "Kot","null","null","null","null","null","null","null");
        app.getKontaktHelper().fillKontaktForm(kontakt);
        app.getKontaktHelper().submitKontaktModification();
        app.getKontaktHelper().returntoHomePage();

        List<KontaktData> after = app.getKontaktHelper().getKontaktList();
        Assert.assertEquals(after.size(), before.size());


       /* Comparator<? super KontaktData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        before.remove(before.size() -1);
        before.add(kontakt);
        Assert.assertEquals(before, after);*/

    }

}

