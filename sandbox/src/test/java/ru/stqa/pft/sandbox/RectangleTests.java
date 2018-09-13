package ru.stqa.pft.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RectangleTests {
    @Test

        public void TestPowierzchnia(){

        Rectangle p = new Rectangle(5,6);


        //Assert.assertEquals(p.powierzchnia(),30.0);
        Assert.assertEquals(p.obwod(),22.0);

    }
}

