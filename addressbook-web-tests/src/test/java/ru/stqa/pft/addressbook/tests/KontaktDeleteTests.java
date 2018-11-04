package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class KontaktDeleteTests extends TestBase
{

    @BeforeMethod
    public void ensurePreconditions() {
        app.kontakt().goHome();
        if(app.kontakt().all().size() == 0)
            app.kontakt().create(new KontaktData().withFirstname("Monika").withLastname("Sowa"));
    }
    @Test
    public void testKontaktDelete()

    {
        Kontakts before = app.kontakt().all();
        KontaktData deletedKontakt = before.iterator().next();
        //KontaktData k = before.get(before.size() - 1);
        //int id_k = k.getId();
        //String id_s = Integer.toString(id_k);
        app.kontakt().delete(deletedKontakt);
        Kontakts after = app.kontakt().all();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedKontakt)));
    }

}




