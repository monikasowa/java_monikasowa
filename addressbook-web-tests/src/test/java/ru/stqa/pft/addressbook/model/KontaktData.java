package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@XStreamAlias("kontakt")
@Entity
@Table(name = "addressbook")
public class KontaktData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    private String company;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    @Type(type = "text")
    private String mail;

    @Column(name = "email2")
    @Type(type = "text")
    private String mail2;

    @Column(name = "email3")
    @Type(type = "text")
    private String mail3;


    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @Transient
    private String allPhones;
    @Transient
    private String allMails;

    @Transient
    private String middlename;
    @Transient
    private String nickname;
    @Transient
    private String byear;
    @Transient
    private String details;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KontaktData that = (KontaktData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(mail2, that.mail2) &&
                Objects.equals(mail3, that.mail3) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(workPhone, that.workPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address, mail, mail2, mail3, homePhone, mobilePhone, workPhone);
    }



    public KontaktData withDetails(String details) {
        this.details = details;
        return this;
    }
    public String getAllPhones() {
        return allPhones;
    }
    public String getAllMails() {
        return allMails;
    }

    public int getId() {
        return id;
    }
    public KontaktData withId(int id) {
        this.id = id;
        return this;
    }
    public KontaktData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    public KontaktData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public void setAddress(String address) { this.address = address; }

    public void setMail(String mail) { this.mail = mail;
    }

    public KontaktData withCompany(String company) {
        this.company = company;
        return this;
    }
    public KontaktData withAddress(String address) {
        this.address = address;
        return this;
    }
    public KontaktData  withMail(String mail) {
        this.mail = mail;
        return this;
    }
    public KontaktData  withMail2(String mail2) {
        this.mail2 = mail2;
        return this;
    }


    public void setMail2(String mail2) {
        this.mail2 = mail2;
    }


    public void setMail3(String mail3) {
        this.mail3 = mail3;
    }

    public KontaktData  withMail3(String mail3) {
        this.mail3 = mail3;
        return this;
    }
    public KontaktData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
    public KontaktData withAllMails(String allMails) {
        this.allMails = allMails;
        return this;
    }
    public KontaktData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }
    public KontaktData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }
    public KontaktData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public KontaktData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }
    public KontaktData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
    public KontaktData withByear(String byear) {
        this.byear = byear;
        return this;
    }

    public String getFirstName() { return firstname; }
    public String getAddress() { return address; }
    public String getMail() { return mail; }
    public String getHomePhone() { return homePhone; }
    public String getMobilePhone() { return mobilePhone; }
    public String getWorkPhone() { return workPhone; }
    public String getLastName() { return lastname; }
    public String getMail2() { return mail2; }
    public String getMail3() { return mail3; }

    @Override
    public String toString() {
        return "KontaktData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


    public void setDetails(String details) {
        this.details = details;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}







