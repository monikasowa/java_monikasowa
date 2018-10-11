package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    private final GroupsHelper groupsHelper;


    public NavigationHelper(WebDriver wd) {
        groupsHelper = new GroupsHelper(wd);
    }


    public GroupsHelper getGroupsHelper() {
        return groupsHelper;
    }

    public void gotoGroupPage() {
        groupsHelper.gotoGroupPage();
    }

    public void gotoHomePage() {
        groupsHelper.gotoHomePage();
    }
}




