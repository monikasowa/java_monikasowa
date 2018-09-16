package ru.stqa.pft.addressbook.model;

public class KontaktData {
    private final String firstname;
    private final String lastname;
    private final String company;
    private final String address;
    private final String mail;
    private final String home;
    private final String middlename;
    private final String nickname;
    private final String byear;

    public KontaktData(String firstname, String lastname, String company, String address, String mail, String home, String middlename, String nickname, String byear){


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

    public String getFirstname() {
        return firstname;
    }
}

