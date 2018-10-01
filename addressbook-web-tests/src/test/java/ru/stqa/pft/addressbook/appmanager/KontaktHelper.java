package ru.stqa.pft.addressbook.appmanager;

import com.sun.xml.internal.ws.org.objectweb.asm.ByteVector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.KontaktData;

import java.nio.file.attribute.BasicFileAttributeView;

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

        if(isElementPresent(By.linkText("home")))  {
            return;//click());
        }
    }

    public void selectKontact() {
        {
            click(By.name("selected[]"));
        }
    }

    public void deleteSelectedKontakts()

        {
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

    public void selectKontakt()
        {
            click(By.name("selected[]"));
        }

   public void initKontaktModification() {
        click(By.name("edit"));

        //to nie chodzi szukam ikony kredka
    }

    public void submitKontaktModifocation() {
        click(By.name("undone"));

    }
}
