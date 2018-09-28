package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.util.ArrayList;
import java.util.List;

public class KontaktHelper extends BaseHelper {



    public KontaktHelper(WebDriver wd) {
        super(wd);
    }

    // public void DelateKontakt() {
    //wd.findElement((By.name("selected[]"))).click();//By.xpath("//div[@id='content']/form[2]/tr[2]/input")).click();
    // }

    // public void ClickDelateKontakt() {
    //wd.findElement((By.name("selected[]"))).click();//By.id("14")).click();
    //}

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
        if (isElementPresent(By.id("maintable")))
        {
            return;//click());
        }
        click(By.linkText("home"));
    }

    public void selectKontact() {
        {
            click(By.name("selected[]"));
        }
    }

    public void deleteSelectedKontakts() {
        {
            if (isElementPresent(By.name("add new"))) {
                click(By.name("delete"));
            }
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

    public List<KontaktData> getKontaktList() {
        List<KontaktData> kontakts = new ArrayList<KontaktData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element: elements) {
            String name = element.getText();
            KontaktData kontakt = new KontaktData("Monika", "Sowa", "Polska", "Uczniowska_24", "monika.sowa.21cn@gmail.com", "4324234", "aaaa", "aaa", "1974");
            kontakts.add(kontakt);
        }
        return kontakts;



    }
}








