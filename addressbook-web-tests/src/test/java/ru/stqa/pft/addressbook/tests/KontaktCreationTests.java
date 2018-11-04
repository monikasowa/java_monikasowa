package ru.stqa.pft.addressbook.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KontaktCreationTests extends TestBase {

    @Test
    public void testKontaktCreation() {
        Kontakts before = app.kontakt().all();
        KontaktData kontakt = new KontaktData().withFirstname("Monika").withLastname("Sowa");
        app.kontakt().create(kontakt);
        assertThat(app.kontakt().count(),equalTo(before.size() + 1));
        Kontakts after = app.kontakt().all();
        assertThat(after, equalTo(before.withAdded(
                kontakt.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
   /* @Test
    public void testBadKontaktCreation() {
        Kontakts before = app.kontakt().all();
        KontaktData kontakt = new KontaktData().withFirstname("Monika'").withLastname("Sowa'");
        app.kontakt().create(kontakt);
        assertThat(app.kontakt().count(),equalTo( before.size()));
        Kontakts after = app.kontakt().all();
        assertThat(after,equalTo(before));
    }*/
}









