package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {


    private int id;

    private final String id;
 final String id;

    private final String name;
    private final String header;
    private final String footer;



    public GroupData(int id, String name, String header, String footer) {

    public GroupData(String id, String name, String header, String footer) {


    public GroupData(String id, String name, String header, String footer) {

                this.id = id;

    public GroupData(String name, String header, String footer) {


    public GroupData(String name, String header, String footer) {

                        this.name = name;
                        this.header = header;
                        this.footer = footer;
                    }





    public GroupData(String name, String header, String footer) {
                        this.id = 0;

         public GroupData(String name, String header, String footer) {
                            this.id = null;


         public GroupData(String name, String header, String footer) {
                                this.id = null;

                                this.name = name;
                                this.header = header;
                                this.footer = footer;
                            }

                            @Override
                            public boolean equals (Object o){
                                if (this == o) return true;
                                if (o == null || getClass() != o.getClass()) return false;
                                GroupData groupData = (GroupData) o;
                                return Objects.equals(id, groupData.id) &&
                                        Objects.equals(name, groupData.name);
                            }

                            @Override
                            public int hashCode () {
                                return Objects.hash(id, name);
                            }

                            public String getId () {
                                return id;
                            }


                            public String getName () {
                                return name;
                            }

                            public String getHeader () {
                                return header;
                            }

                            public String getFooter () {
                                return footer;
                            }

                            @Override
                            public String toString () {
                                return "GroupData{" +


                                "id=" + id +
                                        ", name='" + name + '\'' +
                                        =======
                                "name='" + name + '\'' +

                                '}';
                            }

                            @Override
                            public boolean equals (Object o){
                                if (this == o) return true;
                                if (o == null || getClass() != o.getClass()) return false;
                                GroupData groupData = (GroupData) o;

                                return id == groupData.id &&
                                        Objects.equals(name, groupData.name);
                            }
                            @Override
                            public int hashCode () {
                                return Objects.hash(id, name);
                            }
                            public void setId ( int id){
                                this.id = id;

                                return Objects.equals(name, groupData.name);
                            }

                            @Override
                            public int hashCode () {
                                return Objects.hash(name);

                            }

                            "header='" + header + '\'' +
                                    ", footer='" + footer + '\'' +
                                    '}';
                        }

                        "name='" + name + '\'' +
                                '}';
                    }

                    @Override
                    public boolean equals (Object o){
                        if (this == o) return true;
                        if (o == null || getClass() != o.getClass()) return false;
                        GroupData groupData = (GroupData) o;
                        return Objects.equals(name, groupData.name);
                    }

                    @Override
                    public int hashCode () {
                        return Objects.hash(name);
                    }


                    "header='" + header + '\'' +
                            ", footer='" + footer + '\'' +
                            '}';
                }


            }
        }
