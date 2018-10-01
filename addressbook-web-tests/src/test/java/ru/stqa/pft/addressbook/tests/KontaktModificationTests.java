package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

public class KontaktModificationTests extends TestBase{
    @Test

    public void testKontaktModification()
    {

        app.getKontaktHelper().wd.findElement(By.linkText("home")).click();
        if(!app.getKontaktHelper().isThereAKontakt())
        {
            app.getKontaktHelper().createKontakt(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        }
<<<<<<< HEAD
<<<<<<< HEAD

        //List<KontaktData> before = app.getKontaktHelper().getKontaktList();
=======
       // List<GroupData> before = app.getGroupsHelper().getGroupList();
        
>>>>>>> parent of affbfe3... Warunki wstepne dla grup - poprawka
=======
       // List<GroupData> before = app.getGroupsHelper().getGroupList();
<<<<<<< HEAD

>>>>>>> parent of 34d4175... Porownanie list-usuwana grupa
=======
        
>>>>>>> parent of affbfe3... Warunki wstepne dla grup - poprawka
        app.getKontaktHelper().initKontaktCreation();
        app.getKontaktHelper().fillKontaktForm(new KontaktData("Ala", "Slon", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        app.getKontaktHelper().submitKontaktCreation();
        app.getKontaktHelper().returntoHomePage();
}
}
