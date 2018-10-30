package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.Comparator;
import java.util.List;

public class KontaktModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.getKontaktHelper().gotoMainPage();
        if (!app.getKontaktHelper().isThereAKontakt()) {
            app.getKontaktHelper().createKontakt(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        }
    }

    @Test
    public void testKontaktModification() {
        List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        int index = before.size()-1;
        KontaktData kontakt = new KontaktData(before.get(index).getId(), "Kasia", "Kot","null","null","null","null","null","null","null");

        int max1 = 0;
        for (KontaktData k: before){
            if (k.getId()> max1){
                max1 = k.getId();
            }

        }

        app.getKontaktHelper().modifyKontakt(kontakt, max1,index);
        List<KontaktData> after = app.getKontaktHelper().getKontaktList();
        Assert.assertEquals(after.size(), before.size());


        Comparator<? super KontaktData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        before.remove(index);
        kontakt.setId(max1);
        before.add(kontakt);
        Assert.assertEquals(before, after);

    }



}

