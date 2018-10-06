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
        //type(By.name("firstname"), "Kasia");
        type(By.name("firstname"),groupKontakt.getFirstName());
        //wd.findElement(By.name("middlename")).click();
        type(By.name("lastname"),groupKontakt.getLastName());
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



    public void deleteSelectedKontakts()
        {
            wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
            wd.switchTo().alert().accept();
        }



        public void createKontakt(KontaktData kontakt) {

        initKontaktCreation();
        fillKontaktForm(kontakt);
        submitKontaktCreation();
        returntoHomePage();

    }

    public boolean isThereAKontakt() {
        return isElementPresent(By.name("selected[]"));}


    public void selectKontakt(String i)

        {
            wd.findElement(By.id(i)).click();
        }


        public void submitKontaktModification ()
        {
            click(By.name("update"));
        }


            public void initKontaktModification ()
            {
                wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[6]/td[8]/a/img")).click();
            }


    public void gotoMainPage()
    {
        click(By.linkText("home"));
    }

    public List<KontaktData> getKontaktList() {
        List<KontaktData> kontakts = new ArrayList<KontaktData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {

            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(1).getText();
            String lastname = cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));


            KontaktData kontakt = new KontaktData(id,firstname, lastname, null, null, null, null, null, null, null);
            kontakts.add(kontakt);
        }
        return kontakts;
    }



}



