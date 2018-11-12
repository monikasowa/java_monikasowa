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
        if (app.db().kontakts().size() == 0) {
            app.goTo().goHome();
            app.kontakt().create(new KontaktData()
                    .withFirstname("Monika").withLastname("Sowa"));
        }
    }
    @Test
    public void testKontaktDelete() {

        Kontakts before = app.db().kontakts();
        KontaktData deletedKontakt = before.iterator().next();
       app.goTo().goHome();
       
        app.kontakt().delete(deletedKontakt);
        Kontakts after = app.db().kontakts();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deletedKontakt)));
    }

}




