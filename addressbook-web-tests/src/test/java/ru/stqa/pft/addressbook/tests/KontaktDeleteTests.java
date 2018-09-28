package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.List;

public class KontaktDeleteTests extends TestBase{


    @Test
    public void testKontaktDelete()
    {
        //List<KontaktData> before = app.getKontaktHelper().getKontaktList();
        app.getKontaktHelper().wd.findElement(By.linkText("home")).click();
        app.getKontaktHelper().selectKontact();
        app.getKontaktHelper().deleteSelectedKontakts();
        app.getKontaktHelper().returntoHomePage();

        //List<KontaktData> after = app.getKontaktHelper().getKontaktList();

        //Assert.assertEquals(after.size(), before.size()-1);

        //before.remove(before.size() - 1);;
        //Assert.assertEquals(before, after);
    }
        //app.kontaktHelper.ClickDelateKontakt();
        //app.kontaktHelper.DelateKontakt();
    }


