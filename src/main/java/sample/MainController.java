package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *   KONTROLER PIERWSZEGO OKNA
 */

public class MainController implements Initializable{

    Firma company = new Firma();

    private Boolean czyZalogowany=false;

    Stage stage;

    login log = new login();

    public Stage getStage() { return stage; }


    void setStage(Stage stage) { this.stage = stage; }

    @FXML
    TextField companyNameField, wlascField;

    @FXML
    PasswordField passField;

    @FXML
    Label companyNameLabel, companyNameErrorLabel, startLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startLabel.setText("Podaj dane firmy:");
    }

    /**
     * STATYCZNA METODA ZAMYKAJĄCA PROGRAM
     */
    public static void exit()
    {
        Platform.exit();
        System.exit(0);
    }

    /*

     DODAWANIE PRZYKLADOWYCH HASEL I LOGINOW

     public void dodajUzytkownika(){
     log.dodajUzytkownika(1,"admin","password");
     log.dodajUzytkownika(2, "testlogin", "testpassword");
     }
     */

    /**
     * METODA ZAMYKAJĄCA PROGRAM
     */
    public void exitButton()
    {
        Platform.exit();
        System.exit(0);
    }

    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK USTAWIAJĄCY WARTOSCI W OBIEKCIE KLASY FIRMA
     * ORAZ WYKORZYSTUJACA METODA DZIĘKI KTOREJ MOZEMY LOGOWAĆ SIĘ DO PROGRAMU CO UMOZLIWIA PRZEJSCIE DO KOLEJNEGO OKNA
     */
    public void setCompanyInfo() {
        if(companyNameField.getText().equals("") || passField.getText().equals("") || wlascField.getText().equals(""))  {
            companyNameErrorLabel.setText("Wprowadź Dane Firmy!");
        }
        else
        {
            company.setCompanyName(companyNameField.getText());
            company.setPassword(passField.getText());
            company.setWlasciciel(wlascField.getText());

            if(company.getPassword().equals(log.sprawdzDane(company.getWlasciciel()))) {
                companyNameLabel.setText("Zarządzaj firmą " + company.getCompanyName() + " z naszą pomocą, dziękujemy za zaufanie!");
                czyZalogowany = true;
                companyNameErrorLabel.setText("");
                wlascField.setEditable(false);
                passField.setEditable(false);
            }
            else
            {
                companyNameErrorLabel.setText("Błedne dane!");
            }
        }

    }

    /**
     * METODA OTWIERAJĄCA NOWE OKNO PROGRAMU W KTÓRYM BĘDZIEMY OBSŁUGIWAĆ TABELE BAZY DANYCH INFORMACJI O NASZEJ FIRMIE
     */
    public void goToSecondWindow() throws IOException {
        if(czyZalogowany==false)
        {
            companyNameErrorLabel.setText("Zaloguj się!");
        }
        else
        {
            companyNameErrorLabel.setText("");

            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("secondWindow.fxml"));
            Scene scene = new Scene(fxmlloader.load());

            stage = new Stage();
            stage.setTitle(company.getCompanyName() + " / Wlasciciel: " + company.getWlasciciel() );
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest((e)->(secondWindow.exitSecondWindow()));
            stage.setScene(scene);
            stage.show();

        }

    }

    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK WYSWIETLAJĄCY WPROWADZONE PRZEZ NAS INFORMACJE O FIRMIE
     */
    public void getCompanyDetails(){

        companyNameErrorLabel.setText( " Firma:  " + company.getCompanyName() + " / Wlasciciel: " + company.getWlasciciel());
    }
}