package sample;

import java.sql.*;
import java.util.ArrayList;

public class PracownicyBaza {

    /* private int id = 1; */

    private String wynik;

    private Connection con;

    public PracownicyBaza() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://158.75.112.103:55655/stud2",
                    "stud2", "student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void createTable(String tableName) {
        try {
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE " + tableName +
                    " (ID INT PRIMARY KEY     NOT NULL," +
                    " NAMELASTNAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " SALARY            INT     NOT NULL, " +
                    " POSITION        CHAR(50), " +
                    " CHILDREN        INT  NOT NULL, " +
                    " BONUS        INT  NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectTable(String tableName) {
        try {
            wynik = "";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + tableName + ";" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  name = rs.getString("namelastname");
                int age  = rs.getInt("age");
                float salary = rs.getFloat("salary");
                String  position = rs.getString("position");
                int children  = rs.getInt("children");
                float bonus = rs.getFloat("bonus");

                wynik = wynik + ("ID: " + id + "\nImie i nazwisko: " + name + "\nWiek: " + age + "\nPensja: " + salary + "\nStanowisko: " + position + "\nDzieci: " + children + "\nPremia: " + bonus + "\n\n" );

            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wynik;
        }

    public void dodajPracownika(String tableName, int id, String name, int age, int salary, String position, int children, int bonus) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO " + tableName + " (ID,NAMELASTNAME,AGE,SALARY,POSITION,CHILDREN,BONUS) "
                    + "VALUES (" + id + ",'" + name + "'," + age + ", " + salary + ", '" + position + "', " + children + ", " + bonus + " );";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void zwolnijPracownika(String table, int id) {
        try {
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM " + table + " WHERE ID = " + id + "; ";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dajPremie(String table, int id, int newdata) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE " + table +
                    " SET BONUS = " + newdata
                    + " WHERE ID=" + id + ";" ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void akutalizujDane(String table, String whichdata, int idprac, String newdata) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE " + table +
                    " SET " + whichdata + "= '" + newdata
                    + "' WHERE ID=" + idprac + ";" ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void akutalizujDane(String table, String whichdata, int idprac, int newdata) {
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE " + table +
                    " SET " + whichdata + "= " + newdata
                    + " WHERE ID=" + idprac + ";" ;
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}