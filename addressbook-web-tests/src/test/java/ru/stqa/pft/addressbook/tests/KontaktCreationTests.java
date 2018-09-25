package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

public class KontaktCreationTests extends TestBase {

    @Test
    public void testKontaktCreation() {
        app.getGroupsHelper().initGroupCreation();
        app.kontaktHelper.FillGroupForm(new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974"));
    }


}


