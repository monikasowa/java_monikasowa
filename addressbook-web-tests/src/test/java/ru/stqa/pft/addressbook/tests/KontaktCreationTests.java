package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.Comparator;
import java.util.Set;

public class KontaktCreationTests extends TestBase {
    @Test
    public void testKontaktCreation()
    {
        Set<KontaktData> before = app.kontakt().all();
        KontaktData kontakt = new KontaktData().withFirstname("Monika").withLastname("Sowa");
        app.kontakt().create(kontakt);
        Set<KontaktData> after = app.kontakt().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        kontakt.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(kontakt);
        Assert.assertEquals(before, after);
    }
}








