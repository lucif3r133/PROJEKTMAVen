package sample;

public class Pracownik {


    private int wiek;
    private int pensja;
    private int premia;
    private int liczba_dzieci;
    private int id;
    private String imie_nazwisko;
    private String stanowisko;

    public int getWiek() {
        return wiek;
    }

    public Pracownik(int wiek, int pensja, int premia, int liczba_dzieci, int id, String imie_nazwisko, String stanowisko) {
        this.wiek = wiek;
        this.pensja = pensja;
        this.premia = premia;
        this.liczba_dzieci = liczba_dzieci;
        this.id = id;
        this.imie_nazwisko = imie_nazwisko;
        this.stanowisko = stanowisko;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public int getPremia() {
        return premia;
    }

    public void setPremia(int premia) {
        this.premia = premia;
    }

    public int getLiczba_dzieci() {
        return liczba_dzieci;
    }

    public void setLiczba_dzieci(int liczba_dzieci) {
        this.liczba_dzieci = liczba_dzieci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie_nazwisko() {
        return imie_nazwisko;
    }

    public void setImie_nazwisko(String imie_nazwisko) {
        this.imie_nazwisko = imie_nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

}
