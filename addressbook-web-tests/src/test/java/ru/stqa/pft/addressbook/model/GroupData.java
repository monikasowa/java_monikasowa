package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("group")
@Entity
@Table(name = "group_list")
public class GroupData {

   @XStreamOmitField
   @Id
   @Column(name = "group_id")
    private int id = Integer.MIN_VALUE;

    @Column(name = "group_name")
    private String name;

    @Column(name = "group_header")
    @Type(type = "text")
    private String header;

    @Column(name = "group_footer")
    @Type(type = "text")
    private String footer;




    @ManyToMany(mappedBy = "groups")
    private Set<KontaktData> kontakts = new HashSet<KontaktData>();

    public Set<KontaktData> getKontakts() {
        return kontakts;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, name, header, footer);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(name, groupData.name) &&
                Objects.equals(header, groupData.header) &&
                Objects.equals(footer, groupData.footer);
    }


    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }
    public GroupData withName(String name) {
        this.name = name;
        return this;
    }
    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }
    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }
    public String getName() {
        return name;
    }
    public String getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    public String getFooter() {
        return footer;
    }


}