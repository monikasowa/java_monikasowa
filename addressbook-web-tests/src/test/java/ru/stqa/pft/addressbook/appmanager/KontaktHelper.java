package ru.stqa.pft.addressbook.appmanager;

import javafx.beans.value.ObservableBooleanValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //type(By.name("firstname"), "Kasia");
        type(By.name("firstname"), groupKontakt.getFirstName());
        //wd.findElement(By.name("middlename")).click();
        type(By.name("lastname"), groupKontakt.getLastName());
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

        wd.findElement(By.xpath("//div[@id='nav']//a[.='home']")).click();

    }

    public void deleteSelectedKontakts() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
        wd.switchTo().alert().accept();
    }


    public void create(KontaktData kontakt) {

        initKontaktCreation();
        fillKontaktForm(kontakt);
        submitKontaktCreation();
        goHome();
    }

    public void modify(KontaktData kontakt) {
        selectKontaktById(kontakt.getId());
        initKontaktModification(kontakt.getId());
        fillKontaktForm(kontakt);
        submitKontaktModification();
        goHome();
    }

    public void delete(int index) {
        selectKontakt(index);
        deleteSelectedKontakts();
        returntoHomePage();
    }


    public void delete(KontaktData kontakt) {
        selectKontaktById(kontakt.getId());
        deleteSelectedKontakts();
        returntoHomePage();
    }


    public boolean isThereAKontakt() {
        return isElementPresent(By.name("selected[]"));
    }


    public void selectKontakt(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void selectKontaktById(int id) {
        /*if (!wd.findElement(By.id("208")).isSelected()) {
            wd.findElement(By.id("208")).click();}*/


            wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
        }

        public void submitKontaktModification () {
            click(By.name("update"));
        }

        public void initKontaktModification ( int i){
            click(By.xpath("//a[@href='edit.php?id=" + i + "']"));
        }

        public Kontakts all () {
            Kontakts kontakts = new Kontakts();
            List<WebElement> elements = wd.findElements(By.name("entry"));
            for (WebElement element : elements) {

                List<WebElement> cells = element.findElements(By.tagName("td"));
                String lastname = cells.get(1).getText();
                String firstname = cells.get(2).getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                kontakts.add(new KontaktData().withId(id).withFirstname(firstname).withLastname(lastname));
            }
            return kontakts;
        }


    }






