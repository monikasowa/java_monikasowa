package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    private int id;
=======
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
=======
    private final String id;
>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
=======
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
    private final String name;
    private final String header;
    private final String footer;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    public GroupData(int id, String name, String header, String footer) {
=======
    public GroupData(String id, String name, String header, String footer) {
>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
        this.id = id;
=======
    public GroupData(String name, String header, String footer) {
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
=======
    public GroupData(String name, String header, String footer) {
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    public GroupData(String name, String header, String footer) {
            this.id = 0;
=======
         public GroupData(String name, String header, String footer) {
            this.id = null;
>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
            this.name = name;
            this.header = header;
            this.footer = footer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(id, groupData.id) &&
                Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getId() {
        return id;
    }

=======
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
=======
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
                "id=" + id +
                ", name='" + name + '\'' +
=======
                "name='" + name + '\'' +
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
<<<<<<< HEAD
        return id == groupData.id &&
                Objects.equals(name, groupData.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    public void setId(int id) {
        this.id = id;
=======
        return Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
    }
=======
                "header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

>>>>>>> parent of dfc0685... Porównanie list - tworzona grupa
=======
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(name, groupData.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
>>>>>>> parent of 8c10292... Porownanie list - modyfikowana grupa
}
