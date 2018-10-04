package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

public class KontaktCreationTests extends TestBase {

    @Test
    public void testKontaktCreation() {

        //List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        KontaktData kontakt = new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974");
        app.getKontaktHelper().initKontaktCreation();
        app.getKontaktHelper().fillKontaktForm(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        app.getKontaktHelper().submitKontaktCreation();
        app.getKontaktHelper().returntoHomePage();

        //List<KontaktData> after = app.getKontaktHelper().getKontaktList();

        //Assert.assertEquals(after.size(), before.size()+1 );


        //int max = 0;
       // for (KontaktData g : after) {
           // if (g.getId() > max) {
               // max = g.getId();
          //  }
       // }
       // kontakt.setId(max);
       // before.add(kontakt);
       // Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

    }



