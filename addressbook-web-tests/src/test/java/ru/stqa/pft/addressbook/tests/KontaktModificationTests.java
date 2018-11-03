package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class KontaktModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.kontakt().goHome();
        if (app.group().all().size() == 0) {
            app.kontakt().create(new KontaktData()
                    .withFirstname("Monika").withLastname("Sowa"));
        }
    }

    @Test
    public void testKontaktModification() {
        Set<KontaktData> before = app.kontakt().all();
        KontaktData modifiedKontakt = before.iterator().next();
        KontaktData kontakt = new KontaktData()
                .withId((modifiedKontakt).getId()).withFirstname("Monika").withLastname("Kot");
        /*int max1 = 0;
        for (KontaktData k: before){
        if (k.getId()> max1){
        max1 = k.getId();
        }
         }*/
        app.kontakt().modify(kontakt);
        Set<KontaktData> after = app.kontakt().all();
        assertThat(after.size(),equalTo(before.size()));
        before.remove(modifiedKontakt);
        //kontakt.withId();
        before.add(kontakt);
        assertThat(after, equalTo(before));
    }
}
