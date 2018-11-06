package ru.stqa.pft.addressbook.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class KontaktCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validKontakts() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new KontaktData().withFirstname("firstname 1")
                .withLastname("lastname 1").withAddress("address 1")
                .withMail("mail 1").withHomePhone("home 1")
                .withMobilePhone("mobile 1").withWorkPhone("work 1")});
        list.add(new Object[]{new KontaktData().withFirstname("firstname 2")
                .withLastname("lastname 2").withAddress("address 2")
                .withMail("mail 2").withHomePhone("home 2")
                .withMobilePhone("mobile 2").withWorkPhone("work 2")});
        list.add(new Object[]{new KontaktData().withFirstname("firstname 3")
                .withLastname("lastname 3").withAddress("address 3")
                .withMail("mail 3").withHomePhone("home 3")
                .withMobilePhone("mobile 3").withWorkPhone("work 3")});
        return list.iterator();
    }

    @Test(dataProvider = "validKontakts")
    public void testKontaktCreation(KontaktData kontakt)
    {

        Kontakts before = app.kontakt().all();
      // KontaktData kontakt = new KontaktData().withFirstname("Monika").withLastname("Sowa");
        app.kontakt().create(kontakt);
        assertThat(app.kontakt().count(), equalTo(before.size() + 1));
        Kontakts after = app.kontakt().all();
        assertThat(after, equalTo(before.withAdded(
                kontakt.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
