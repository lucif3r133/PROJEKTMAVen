package sample;

import java.sql.*;

public class PracownicyBaza {

    /* private int id = 1; */

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

    public void selectTable(String tableName) {
        try {
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
                System.out.println( "ID = " + id );
                System.out.println( "imie i nazwisko = " + name );
                System.out.println( "wiek = " + age );
                System.out.println( "pensja = " + salary );
                System.out.println( "stanowisko = " + position );
                System.out.println( "liczba dzieci = " + children );
                System.out.println( "premia = " + bonus );
                System.out.println();
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}

