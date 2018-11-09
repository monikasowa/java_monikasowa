package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import ru.stqa.pft.addressbook.model.KontaktData;
import ru.stqa.pft.addressbook.model.Kontakts;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;

public class DbConnectionTest {


   @Test
    public void testDbConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?serverTimezone=UTC&user=root&password=");
            Statement st = conn.createStatement();
            Groups groups = new Groups();
            ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
            while (rs.next()) {
               groups.add(new GroupData() .withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                       .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
            }
            rs.close();
            st.close();
            conn.close();

            System.out.println(groups);

            // Do something with the Connection
           /* try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?" +
                        "user=root&password=");
                /*Statement st = conn.createStatement();
                Kontakts kontakts = new Kontakts();
                ResultSet rs = st.executeQuery("select group_id, group_name, group_header, group_footer from group_list");
                while (rs.next()) {
                    kontakts.add(new KontaktData() .withId(rs.getInt("kontakt_id")).withName(rs.getString("group_name"))
                            .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
                }
                rs.close();
                st.close();
                conn.close();

                System.out.println(groups);
                // Do something with the Connection*/


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
