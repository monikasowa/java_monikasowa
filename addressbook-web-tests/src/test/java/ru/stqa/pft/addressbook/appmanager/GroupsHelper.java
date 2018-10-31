package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupsHelper extends BaseHelper {


    public GroupsHelper(WebDriver wd) {
        super(wd);
    }


    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {

        click(By.name("group_name"));
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        click(By.name("group_header"));
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        click(By.name("group_footer"));
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());


    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        if (isElementPresent(By.name("new"))) {
            click(By.name("delete"));
        }
    }
    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" +id +"']")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {

        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returntoGroupPage();
    }


    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returntoGroupPage();
    }


    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        returntoGroupPage();
    }

    public void returntoGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public Set<GroupData> all() {
        Set<GroupData> groups = new HashSet<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }


}

