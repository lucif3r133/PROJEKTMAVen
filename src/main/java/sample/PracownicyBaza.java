package sample;

import java.sql.*;


/**
 * KLASA UMOZLIWIAJĄCA POŁĄCZENIE SIĘ Z BAZĄ DANYCH I JEJ OBSŁUGĘ
 */

public class PracownicyBaza {


    private String wynik;

    private Connection con;

    /**
     *  KONSTRUKTOR, TWORZENIE POŁACZENIA Z BAZĄ DANYCH
     */
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


    /**
     * METODA UMOZLIWIA STWORZENIE NOWEJ TABELI W BAZIE DANYCH
     * @param tableName TO NAZWA TABELI W BAZIE Z KTÓREJ BĘDZIEMY KORZYSTALI
     */
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

    /**
     * METODA UMOŻLIWIAJĄCA ZWRÓCENIE ZAWARTOŚCI TABELI KTÓRĄ AKTUALNIE USTAWILIŚMY
     * @param tableName TO TABELA KTÓREJ ZAWARTOŚĆ CHCEMY ZWRÓCIĆ
     * @return  ZAWARTOŚĆ TABELI
     */
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

    /**
     * METODA UMOŻLIWIAJĄCA DODANIE NOWEGO PRACOWNIKA DO TABELI Z NASTEPUJĄCYMI PARAMETRAMI
     * @param tableName NAZWA TABELI DO KTÓREJ DODAJEMY PRACOWNIKA
     * @param id ID PRACOWNIKA
     * @param name IMIE I NAZWISKO PRACOWNIKA
     * @param age WIEK PRACOWNIKA
     * @param salary WYPŁATA PRACOWNIKA
     * @param position POZYCJA W FIRMIA PRACOWNIKA
     * @param children LICZBA DZIECI PRACOWNIKA
     * @param bonus PREMIA PRACOWNIKA
     */
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

    /**
     * METODA UMOŻLIWIAJĄCA USUNIĘCIE Z BAZY WIERSZA O WYBRANYM ID
     * @param table NAZWA TABELI Z KTÓREJ CHCEMY USUNĄĆ WYBRANY WIERSZ
     * @param id ID WIERSZA KTÓRY ZAMIERZEMY USUNĄĆ
     */
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

    /**
     * METODA UMOŻLIWIAJĄCA ZAAKTUALIZOWANIE ZAWARTOŚCI KOLUMNY BONUS DLA WYBRANEGO ID
     * @param table NAZWA TABELI
     * @param id ID
     * @param newdata NOWA WARTOŚĆ KTÓRĄ WPROWADZIMY DO KOLUMNY BONUS
     */
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

    /**
     * METODA AKTUALIZUJACA DANE WYBRANEGO WIERSZA TABELI
     * @param table NAZWA TABELI
     * @param whichdata NAZWA KOLUMNY KTÓRA CHCEMY ZAAKTUALIZOWAĆ
     * @param idprac ID WIERSZA KTÓRY CHCEMY ZAAKTUALIZOWAĆ
     * @param newdata NOWA ZAWARTOŚĆ KOLUMNY WYBRANEGO WIERSZA STRING
     */
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

    /**
     * METODA AKTUALIZUJACA DANE WYBRANEGO WIERSZA TABELI
     * @param table NAZWA TABELI
     * @param whichdata NAZWA KOLUMNY KTÓRA CHCEMY ZAAKTUALIZOWAĆ
     * @param idprac ID WIERSZA KTÓRY CHCEMY ZAAKTUALIZOWAĆ
     * @param newdata NOWA ZAWARTOŚĆ KOLUMNY WYBRANEGO WIERSZA INT
     */
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