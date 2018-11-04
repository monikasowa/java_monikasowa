package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KontaktPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.kontakt().goHome();
        if (app.kontakt().all().size() == 0) {
            app.kontakt().create(new KontaktData()
                    .withFirstname("Monika").withLastname("Sowa")
                    //.withAddress("Uczniowska 18, 43-100, Tychy").withMail("monikasowa.21cn@gmail.com")
                    .withHomePhone("345").withMobilePhone("375").withWorkPhone("345"));
        }
    }
    @Test
    public void testKontaktPhone() {
        app.goTo().goHome();
        KontaktData kontakt = app.kontakt().all().iterator().next();
        KontaktData kontaktInfoFromEditForm = app.kontakt().infoFromEditForm(kontakt);

        assertThat(kontakt.getHomePhone(), equalTo(cleaned(kontaktInfoFromEditForm.getHomePhone())));
        assertThat(kontakt.getMobilePhone(), equalTo(cleaned(kontaktInfoFromEditForm.getMobilePhone())));
        assertThat(kontakt.getWorkPhone(), equalTo(cleaned(kontaktInfoFromEditForm.getWorkPhone())));
    }
    public String cleaned(String phone) { ;
        return phone.replaceAll("\\s", "").replaceAll("[-()]",  "");
    }
}
