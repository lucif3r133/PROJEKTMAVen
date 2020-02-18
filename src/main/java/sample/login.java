package sample;

import java.sql.*;

public class login {

    private Connection con;

    /**
     * KONSTRUKTOR, TWORZENIE POŁACZENIA Z BAZĄ DANYCH
     */
    public login() {
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

    public void dodajUzytkownika(int id, String username, String password) {
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO PROJLOGIN (ID ,USERNAME, PASSWORD) "
                    + "VALUES (" + id + ",'" + username + "','" + password + "' );";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String sprawdzDane(String username) {
        String password = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJLOGIN WHERE USERNAME='" + username + "';");
            while ( rs.next() )
            {
                password = rs.getString("PASSWORD");
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return password;
    }

}
