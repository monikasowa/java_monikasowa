package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        initGroupCreation();
        fillGroupForm(new GroupData("test4", "test5", "test6"));
        submitGroupCreation();
        returntoGroupPage();

    }

}


