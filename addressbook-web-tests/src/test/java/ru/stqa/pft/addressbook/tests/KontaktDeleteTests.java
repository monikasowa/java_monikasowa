package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class KontaktDeleteTests extends TestBase{


    @Test
    public void testKontaktDelete() {


        app.kontaktHelper.ClickDelateKontakt();
        app.kontaktHelper.DelateKontakt();
    }

}
