package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupsHelper extends BaseHelper {


    public GroupsHelper(WebDriver wd) {

        super(wd);
    }


    public void returntoGroupPage() {
        click(By.linkText("group page"));
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public void selectGroup(int i){
=======
    public void selectGroup() {
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
=======
    public void selectGroup(int i) {
>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
=======
    public void selectGroup() {
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
=======
    public void selectGroup(int i) {
>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
        click(By.name("selected[]"));
    }

    public void initGroupModification() {

        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {

        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returntoGroupPage();

    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element: elements) {
            String name = element.getText();
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
=======
            String id = element.findElement(By.tagName("input")).getAttribute("value");
>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
=======
            String id = element.findElement(By.tagName("input")).getAttribute("value");
>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
            GroupData group = new GroupData(id, name, null, null);
=======
            GroupData group = new GroupData(name, null, null);
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
=======
            GroupData group = new GroupData(name, null, null);
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
            groups.add(group);
        }
        return groups;



    }
}

