package ru.stqa.pft.addressbook.tests;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class KontaktModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().kontakts().size() == 0) {
            app.goTo().goHome();
            app.kontakt().create(new KontaktData()
                    .withFirstname("Monika").withLastname("Sowa"));
        }
    }
    @Test
    public void testKontaktModification() {
        Kontakts before = app.db().kontakts();
        KontaktData modifiedKontakt = before.iterator().next();
        KontaktData kontakt = new KontaktData()
                .withId((modifiedKontakt).getId()).withFirstname("Monika").withLastname("Kot")
                .withAddress("Uczniowska").withMail("m.s@gmail.com").withMail2("m.s@gmail.com")
                .withMail3("m.s@gmail.com").withHomePhone("786").withMobilePhone("564").withWorkPhone("897");
        app.goTo().goHome();
        app.kontakt().modify(kontakt);
        assertThat(app.kontakt().count(),equalTo( before.size()));
        Kontakts after = app.db().kontakts();
        assertThat(after, equalTo(before.without(modifiedKontakt).withAdded(kontakt)));
    }
}

