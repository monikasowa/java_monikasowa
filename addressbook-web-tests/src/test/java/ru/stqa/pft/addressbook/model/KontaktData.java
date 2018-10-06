package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class KontaktData {
    private int id;
    private final String firstname;
    private final String lastname;
    private final String company;
    private final String address;
    private final String mail;
    private final String home;
    private final String middlename;
    private final String nickname;
    private final String byear;


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



    public String getFirstName() {
        return firstname;
    }


    public void setId(int max) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "KontaktData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", home='" + home + '\'' +
                ", middlename='" + middlename + '\'' +
                ", nickname='" + nickname + '\'' +
                ", byear='" + byear + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KontaktData that = (KontaktData) o;

        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(company, that.company) &&
                Objects.equals(address, that.address) &&
                Objects.equals(mail, that.mail) &&
                Objects.equals(home, that.home) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(nickname, that.nickname) &&
                Objects.equals(byear, that.byear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, company, address, mail, home, middlename, nickname, byear);
    }


    public String getLastName() {
        return lastname;
    }
}







