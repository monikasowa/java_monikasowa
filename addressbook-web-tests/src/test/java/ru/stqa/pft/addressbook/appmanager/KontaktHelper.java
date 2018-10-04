package ru.stqa.pft.addressbook.appmanager;

import com.sun.xml.internal.ws.org.objectweb.asm.ByteVector;
import javafx.beans.value.ObservableBooleanValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.nio.file.attribute.BasicFileAttributeView;
import java.util.ArrayList;
import java.util.List;

public class KontaktHelper extends BaseHelper {


    private ObservableBooleanValue cell;


    public KontaktHelper(WebDriver wd) {
        super(wd);
    }


    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void fillKontaktForm(KontaktData groupKontakt) {

        //type(By.name("firstname"), groupKontakt.getFirstname());
        type(By.name("firstname"), "Basia");
        //wd.findElement(By.name("middlename")).click();
        type(By.name("lastname"), "Sowa");
        type(By.name("company"), "Polska");
        type(By.name("address"), "Uczniowska 24");
        type(By.name("email"), "monika.sowa.21cn@gmail.com");
        type(By.name("home"), "324221745");
        type(By.name("middlename"), "MS");
        type(By.name("nickname"), "Sowka");
        type(By.name("byear"), "1988");
        //wd.findElement(By.name("submit")).click();
    }

    public void initKontaktCreation() {
        click(By.linkText("add new"));
    }

    public void submitKontaktCreation() {
        click(By.name("submit"));
    }


    public void returntoHomePage() {

        if (isElementPresent(By.linkText("home"))) {

            return;
        }
    }

    public void selectKontact(int i) {
        {
            click(By.name("selected[]"));
        }
    }

    public void deleteSelectedKontakts() {
        if (isElementPresent(By.className("maintable")))
        {
            click(By.name("delete"));
        }
    }


        public void createKontakt(KontaktData kontakt) {

        initKontaktCreation();
        fillKontaktForm(kontakt);
        submitKontaktCreation();
        returntoHomePage();

    }

    public boolean isThereAKontakt() {
        return isElementPresent(By.name("selected[]"));
    }

    public void selectKontakt() {

        wd.findElement(By.linkText("home")).click();
        if (!wd.findElement(By.id("51")).isSelected()) {
            wd.findElement(By.id("51")).click();
        }
    }

        public void submitKontaktModification ()
        {
            click(By.name("update"));
        }


            public void initKontaktModification ()
            {
                wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();
            }


    public void gotoMainPage()
    {
        click(By.linkText("home"));
    }

    public List<KontaktData> getKontaktList() {
        List<KontaktData> kontakts = new ArrayList<KontaktData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement row : elements) {

            List<WebElement> tabCells = row.findElements(By.tagName("td"));
            String firstname = tabCells.get(1).getText();
            String lastname = tabCells.get(2).getText();
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));


            KontaktData kontakt = new KontaktData(firstname, lastname, null, null, null, null, null, null, null);
            kontakts.add(kontakt);
        }
        return kontakts;
    }


}



