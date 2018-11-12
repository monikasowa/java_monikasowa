package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class KontaktCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validKontakts() throws IOException {
       try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/kontakts.xml")))){
           String xml = "";
           String line = reader.readLine();
           while (line != null) {
               xml += line;
               line = reader.readLine(); }
           XStream xstream = new XStream();
           xstream.processAnnotations(KontaktData.class);
           List<KontaktData> kontakts = (List<KontaktData>) xstream.fromXML(xml);

           return kontakts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
       }
    }

    @Test(dataProvider = "validKontakts")
    public void testKontaktCreation(KontaktData kontakt)
    {
     Kontakts before = app.db().kontakts();
        app.goTo().goHome();
        app.kontakt().create(kontakt);
       // assertThat(app.kontakt().count(), equalTo(before.size() + 1));
        Kontakts after = app.db().kontakts();
        assertThat(after, equalTo(before.withAdded(
                kontakt.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}
