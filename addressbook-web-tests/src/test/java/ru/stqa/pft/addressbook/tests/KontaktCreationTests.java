package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;

public class KontaktCreationTests extends TestBase {

    @Test
<<<<<<< HEAD
    public void testKontaktCreation()
    {
<<<<<<< HEAD
        //List<KontaktData> before = app.getKontaktHelper().getKontaktList();
=======
    public void testKontaktCreation() {

>>>>>>> parent of 9a2f8aa... Warunki wstepne dla kontaktu - poprawka
=======

>>>>>>> parent of 34d4175... Porownanie list-usuwana grupa
        app.getKontaktHelper().initKontaktCreation();
        app.getKontaktHelper().fillKontaktForm(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
        app.getKontaktHelper().submitKontaktCreation();
        app.getKontaktHelper().returntoHomePage();

        //app.getGroupsHelper().initGroupCreation();

    }



}


