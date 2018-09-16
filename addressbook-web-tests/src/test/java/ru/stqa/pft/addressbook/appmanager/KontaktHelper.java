package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.KontaktData;

public class KontaktHelper extends BaseHelper{

    public KontaktHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void DelateKontakt() {
        wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
    }

    public void ClickDelateKontakt() {
        wd.findElement(By.id("14")).click();
    }

   public void initGroupCreation() {
        wd.findElement(By.linkText("add new")).click();
    }
    public void FillGroupForm(KontaktData groupKontakt) {
        type(By.name("firstname"), groupKontakt.getFirstname());
        wd.findElement(By.name("middlename")).click();
        type(By.name("lastname"), "Sowa");
        type(By.name("company"), "Polska");
        type(By.name("address"), "Uczniowska 24");
        type(By.name("email"), "monika.sowa.21cn@gmail.com");
        type(By.name("home"), "324221745");
        type(By.name("middlename"), "MS");
        type(By.name("nickname"), "Sowka");
        type(By.name("byear"), "1988");
        wd.findElement(By.name("theform")).click();
    }

}

