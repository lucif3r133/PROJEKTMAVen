package sample;

public class Firma {

    private String companyName;
    private String wlasciciel;
    private String password;


    /**
     * KLASA W KTÓREJ ZAPISUJEMY INFORMACJE O FIRMIE W PIERRWSZYM OKNIE
     */
    public Firma() {
    }

    public Firma(String companyName, String wlasciciel, String password) {

        this.companyName = companyName;
        this.wlasciciel = wlasciciel;
        this.password = password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}