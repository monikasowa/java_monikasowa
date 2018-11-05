package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class KontaktData {

    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String lastname;
    private String company;
    private String address;
    private String mail;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String middlename;
    private String nickname;
    private String byear;
    private String allPhones;

    public String getAllPhones() {
        return allPhones;
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
    public KontaktData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
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
    public String getFirstName() {
        return firstname;
    }
    public String getAddress() {
        return address;
    }
    public String getMail() {
        return mail;
    }
    public String getHomePhone() { return homePhone; }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public String getWorkPhone() {
        return workPhone;
    }
    public String getLastName() {
        return lastname;
    }

    @Override
    public String toString() {
        return "KontaktData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KontaktData that = (KontaktData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }
}







