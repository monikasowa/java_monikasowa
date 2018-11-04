package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class KontaktModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.kontakt().goHome();
        if (app.kontakt().all().size() == 0) {
            app.kontakt().create(new KontaktData()
                    .withFirstname("Monika").withLastname("Sowa"));
        }
    }
    @Test
    public void testKontaktModification() {
        Kontakts before = app.kontakt().all();
        KontaktData modifiedKontakt = before.iterator().next();
        KontaktData kontakt = new KontaktData()
                .withId((modifiedKontakt).getId()).withFirstname("Monika").withLastname("Kot");
        app.kontakt().modify(kontakt);
        assertThat(app.kontakt().count(),equalTo( before.size()));
        Kontakts after = app.kontakt().all();
        assertThat(after, equalTo(before.without(modifiedKontakt).withAdded(kontakt)));
    }


}
