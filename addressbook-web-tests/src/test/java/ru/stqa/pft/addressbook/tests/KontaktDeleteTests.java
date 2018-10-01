package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class KontaktDeleteTests extends TestBase{


    @Test
<<<<<<< HEAD
<<<<<<< HEAD
    public void testKontaktDelete()
    {
<<<<<<< HEAD
        //List<KontaktData> before = app.getKontaktHelper().getKontaktList();
=======
=======
>>>>>>> parent of 9a2f8aa... Warunki wstepne dla kontaktu - poprawka
    public void testKontaktDelete() {

>>>>>>> parent of 9a2f8aa... Warunki wstepne dla kontaktu - poprawka
=======

>>>>>>> parent of 34d4175... Porownanie list-usuwana grupa
        app.getKontaktHelper().wd.findElement(By.linkText("home")).click();
        app.getKontaktHelper().selectKontact();
        app.getKontaktHelper().deleteSelectedKontakts();
        app.getKontaktHelper().returntoHomePage();

        //app.kontaktHelper.ClickDelateKontakt();
        //app.kontaktHelper.DelateKontakt();
    }

}
