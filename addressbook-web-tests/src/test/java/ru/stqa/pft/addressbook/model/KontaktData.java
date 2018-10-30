package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class KontaktData {

    private int id;



    private String firstname;
    private String lastname;
    private String company;
    private String address;
    private String mail;
    private String home;
    private String middlename;
    private String nickname;
    private String byear;



    public KontaktData(String firstname, String lastname, String company, String address, String mail, String home, String middlename, String nickname, String byear) {
        this.id = 0;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.mail = mail;
        this.home = home;
        this.middlename = middlename;
        this.nickname = nickname;
        this.byear = byear;

    }




    public KontaktData(int id, String firstname, String lastname, String company, String address, String mail, String home, String middlename, String nickname, String byear) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.mail = mail;
        this.home = home;
        this.middlename = middlename;
        this.nickname = nickname;
        this.byear = byear;
    }

    public int getId() {
        return id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setByear(String byear) {
        this.byear = byear;
    }



    public String getFirstName() {
        return firstname;
    }




    public String getLastName() {
        return lastname;
    }


    public Object getFirstname() {
        return firstname;
    }




    public Object getLasttname() {
        return firstname;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KontaktData that = (KontaktData) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public String toString() {
        return "KontaktData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


}







