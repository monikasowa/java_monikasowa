package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

public class KontaktModificationTests extends TestBase{
    @Test

    public void testKontaktModification() {



        app.getKontaktHelper().gotoMainPage();
        if(!app.getKontaktHelper().isThereAKontakt())
        {
            app.getKontaktHelper().createKontakt(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        }
        // List<GroupData> before = app.getGroupsHelper().getGroupList();
        app.getKontaktHelper().selectKontakt();
        app.getKontaktHelper().initKontaktModification();
        app.getKontaktHelper().fillKontaktForm(new KontaktData("Ala", "Slon", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        app.getKontaktHelper().submitKontaktModification();
        app.getKontaktHelper().returntoHomePage();
    }
}