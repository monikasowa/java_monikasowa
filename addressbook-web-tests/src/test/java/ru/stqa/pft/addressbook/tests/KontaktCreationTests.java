package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class KontaktCreationTests extends TestBase {

    @Test
    public void testKontaktCreation() {

        List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        KontaktData kontakt = new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974");
        app.getKontaktHelper().initKontaktCreation();
        app.getKontaktHelper().fillKontaktForm(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        app.getKontaktHelper().submitKontaktCreation();
        app.getKontaktHelper().returntoHomePage();
        List<KontaktData> after = app.getKontaktHelper().getKontaktList();
        Assert.assertEquals(after.size(), before.size() + 1);


        before.add(kontakt);
        Comparator<? super KontaktData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}







