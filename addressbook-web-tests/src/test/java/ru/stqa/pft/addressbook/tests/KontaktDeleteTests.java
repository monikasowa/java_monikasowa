package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class KontaktDeleteTests extends TestBase{


    @Test
    public void testKontaktDelete()
    {

        app.getKontaktHelper().wd.findElement(By.linkText("home")).click();
        app.getKontaktHelper().selectKontact();
        app.getKontaktHelper().deleteSelectedKontakts();
        app.getKontaktHelper().returntoHomePage();

        //app.kontaktHelper.ClickDelateKontakt();
        //app.kontaktHelper.DelateKontakt();
    }

}
