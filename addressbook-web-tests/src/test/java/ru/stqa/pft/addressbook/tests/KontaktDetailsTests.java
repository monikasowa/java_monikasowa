package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.model.KontaktData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

    public class KontaktDetailsTests extends TestBase {

        @BeforeMethod
        public void ensurePreconditions() {
            app.kontakt().goHome();
            if (app.kontakt().all().size() == 0) {
                app.kontakt().create(new KontaktData()
                        .withFirstname("Monika").withLastname("Sowa")
                        .withAddress("Uczniowska 18, 43-100, Tychy").withMail("monikasowa.21cn@gmail.com")
                        .withHomePhone("567").withMobilePhone("278").withWorkPhone("349"));
            }
        }
        @Test
        public void testKontaktDetails() {
            app.goTo().goHome();
            KontaktData kontakt = app.kontakt().all().iterator().next();
            KontaktData kontaktInfoFromDetailsForm = app.kontakt().infoFromDetailsForm(kontakt);

            assertThat(kontakt.getDetails(), equalTo(kontaktInfoFromDetailsForm.getDetails()));
        }
        @Test
        public void testKontaktDetails1() {
            app.goTo().goHome();
            KontaktData kontakt = app.kontakt().all().iterator().next();
            KontaktData kontaktInfoFromDetailsForm = app.kontakt().infoFromDetailsForm(kontakt);

            assertThat(kontakt.getDetails1(), equalTo(kontaktInfoFromDetailsForm.getDetails1()));
        }
    }


