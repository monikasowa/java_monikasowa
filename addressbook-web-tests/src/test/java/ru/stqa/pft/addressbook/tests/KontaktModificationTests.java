package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.List;

public class KontaktModificationTests extends TestBase {
    @Test

    public void testKontaktModification() {

        app.getKontaktHelper().wd.findElement(By.linkText("home")).click();
        if (!app.getKontaktHelper().isThereAKontakt()) {
            app.getKontaktHelper().createKontakt(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        }

        //List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        app.getKontaktHelper().initKontaktCreation();
        app.getKontaktHelper().fillKontaktForm(new KontaktData("Ala", "Slon", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        app.getKontaktHelper().submitKontaktCreation();
        app.getKontaktHelper().returntoHomePage();

        //List<KontaktData> after = app.getKontaktHelper().getKontaktList();
        //Assert.assertEquals(after.size(), before.size());

        //before.set(before.size() - 1, new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));

        //Comparator<? super KontaktData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
       // before.sort(byId);
        //after.sort(byId);
       // Assert.assertEquals(before, after);

   // }
}
}
