package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.Set;

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
        Set<KontaktData> before = app.kontakt().all();
        KontaktData deletedKontakt = before.iterator().next();
        //KontaktData k = before.get(before.size() - 1);
        //int id_k = k.getId();
        //String id_s = Integer.toString(id_k);
        app.kontakt().delete(deletedKontakt);
        Set<KontaktData> after = app.kontakt().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedKontakt);
        //Assert.assertEquals(after.size(),before.size() - 1);
        Assert.assertEquals(before.size(), after.size());
    }

    }



