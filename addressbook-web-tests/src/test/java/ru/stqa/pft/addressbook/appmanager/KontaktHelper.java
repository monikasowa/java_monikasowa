package ru.stqa.pft.addressbook.appmanager;


import javafx.beans.value.ObservableBooleanValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import java.util.List;

public class KontaktHelper extends BaseHelper {


    public Integer count;
    private ObservableBooleanValue cell;


    public KontaktHelper(WebDriver wd) {
        super(wd);
    }


    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void fillKontaktForm(KontaktData groupKontakt) {


        type(By.name("firstname"), groupKontakt.getFirstName());
        type(By.name("lastname"), groupKontakt.getLastName());
        type(By.name("company"), "Polska");
        type(By.name("address"), groupKontakt.getAddress());
        type(By.name("email"), groupKontakt.getMail());
        type(By.name("email2"), groupKontakt.getMail2());
        type(By.name("email3"), groupKontakt.getMail3());
        type(By.name("home"), groupKontakt.getHomePhone());
        type(By.name("mobile"), groupKontakt.getMobilePhone());
        type(By.name("work"), groupKontakt.getWorkPhone());
        type(By.name("middlename"), "MS");
        type(By.name("nickname"), "Sowka");
        type(By.name("byear"), "1988");
        //wd.findElement(By.name("submit")).click();

        }

    public void initKontaktCreation() {
        wd.findElement(By.linkText("add new")).click();
       // click(By.linkText("add new"));
    }

    public void submitKontaktCreation() {
        click(By.name("submit"));
    }


    public void returntoHomePage() {

        wd.findElement(By.xpath("//div[@id='nav']//a[.='home']")).click();
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
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

    public void submitKontaktModification() {
        click(By.name("update"));
    }

    public void initKontaktModification(int i) {
        click(By.xpath("//a[@href='edit.php?id=" + i + "']"));
    }

    public Kontakts all() {
        Kontakts kontakts = new Kontakts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String address = cells.get(3).getText();
            String allMails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();

            kontakts.add(new KontaktData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withAddress(address).withAllMails(allMails)
                    .withAllPhones(allPhones));
        }
        return kontakts;
    }

    public KontaktData infoFromEditForm(KontaktData kontakt) {
        initKontaktModificationById(kontakt.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String mail = wd.findElement(By.name("email")).getAttribute("value");
        String mail2 = wd.findElement(By.name("email2")).getAttribute("value");
        String mail3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");

        wd.navigate().back();
        return new KontaktData().withId(kontakt.getId()).withFirstname(firstname)
                .withLastname(lastname).withHomePhone(home).withMobilePhone(mobile)
                .withWorkPhone(work).withAddress(address).withMail(mail).withMail2(mail2).withMail3(mail3);

    }

    public KontaktData infoFromDetailsForm(KontaktData kontakt) {

        initKontaktDetailsById(kontakt.getId());
        String firstname = wd.findElement(By.xpath("//div[@id='content']")).getText();
        /*String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String mail = wd.findElement(By.name("email")).getAttribute("value");
        String mail2 = wd.findElement(By.name("email2")).getAttribute("value");
        String mail3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");*/

        wd.navigate().back();
        return new KontaktData().withId(kontakt.getId()).withFirstname(firstname);
               /* .withLastname(lastname).withHomePhone(home).withMobilePhone(mobile)
                .withWorkPhone(work).withAddress(address).withMail(mail);*/
        }
        private void initKontaktModificationById ( int i){
            click(By.xpath("//a[@href='edit.php?id=" + i + "']"));
        }
        // wd.findElement(By.cssSelector(String.format("a[@href='edit.php?id=%s']", id))).click();}

        private void initKontaktDetailsById ( int i){
            //wd.findElement(By.xpath("//div[@id='content']")).click();

        click(By.xpath("//a[@href='view.php?id=" + i + "']")); }
    }

