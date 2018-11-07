package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.KontaktData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class KontaktPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.kontakt().goHome();
        if (app.kontakt().all().size() == 0) {
            app.kontakt().create(new KontaktData()
                    .withFirstname("Monika").withLastname("Sowa")
                    .withAddress("Uczniowska 18, 43-100, Tychy").withMail("monikasowa.21cn@gmail.com")
                    .withMail2("monikasowa.21cn@gmail.com").withMail3("monikasowa.21cn@gmail.com")
                    .withHomePhone("567").withMobilePhone("278").withWorkPhone("349"));
        }
    }
    @Test
    public void testKontaktPhone() {
        app.goTo().goHome();
        KontaktData kontakt = app.kontakt().all().iterator().next();
        KontaktData kontaktInfoFromEditForm = app.kontakt().infoFromEditForm(kontakt);


        assertThat(kontakt.getAllPhones(), equalTo(mergePhones(kontaktInfoFromEditForm)));
        assertThat(kontakt.getAddress(), equalTo(kontaktInfoFromEditForm.getAddress()));
        assertThat(kontakt.getAllMails(), equalTo(mergeMails(kontaktInfoFromEditForm)));

    }

    private String mergePhones(KontaktData kontakt) {
        return Arrays.asList(kontakt.getHomePhone(), kontakt.getMobilePhone(), kontakt.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(KontaktPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone)
    {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }


    private String mergeMails(KontaktData kontakt) {
        return Arrays.asList(kontakt.getMail(), kontakt.getMail2(), kontakt.getMail3())
                .stream().filter((s) -> !s.equals(""))
                .map(KontaktPhoneTests::cleaned1)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned1(String mail)
    {
        return mail.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}


