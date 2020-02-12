package sample;

public class Firma {

    private String companyName;
    private String wlasciciel;
    private String rodzajDzialalnosci;


    /**
     * KLASA W KTÓREJ ZAPISUJEMY INFORMACJE O FIRMIE W PIERRWSZYM OKNIE
     */
    public Firma() {
    }

    public Firma(String companyName, String wlasciciel, String rodzajDzialalnosci) {

        this.companyName = companyName;
        this.wlasciciel = wlasciciel;
        this.rodzajDzialalnosci = rodzajDzialalnosci;

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public String getRodzajDzialalnosci() {
        return rodzajDzialalnosci;
    }

    public void setRodzajDzialalnosci(String rodzajDzialalnosci) {
        this.rodzajDzialalnosci = rodzajDzialalnosci;
    }
}