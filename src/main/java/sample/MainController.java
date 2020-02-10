package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable{

    Firma company = new Firma();

    private Boolean czyUstawione=false;

    Stage stage;

    public Stage getStage() { return stage; }

    void setStage(Stage stage) { this.stage = stage; }

    @FXML
    Button exitButton, setCompanyNameButton, secondWindowButton;

    @FXML
    TextField companyNameField, wlascField, rodzajField;

    @FXML
    Label companyNameLabel, companyNameErrorLabel, startLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startLabel.setText("Podaj dane firmy:");
    }

    public static void exit()
    {
        Platform.exit();
        System.exit(0);
    }

    public void exitButton()
    {
        Platform.exit();
        System.exit(0);
    }

    public void setCompanyInfo() {
        if(companyNameField.getText().equals("") || wlascField.getText().equals("") || rodzajField.getText().equals(""))  {
            companyNameErrorLabel.setText("Wprowadź Dane Firmy!");
        }
        else
        {
            company.setCompanyName(companyNameField.getText());
            company.setRodzajDzialalnosci(rodzajField.getText());
            company.setWlasciciel(wlascField.getText());

            companyNameLabel.setText("Zarządzaj firmą " + company.getCompanyName() + " z naszą pomocą, dziękujemy za zaufanie!");
            czyUstawione = true;
            companyNameErrorLabel.setText("");
        }

    }

    public void goToSecondWindow() throws IOException {
        if(czyUstawione==false)
        {
            companyNameErrorLabel.setText("Najpierw Wprowadź Nazwe Firmy!");
        }
        else
        {
            companyNameErrorLabel.setText("");

            FXMLLoader fxmlloader = new FXMLLoader();
            fxmlloader.setLocation(getClass().getResource("secondWindow.fxml"));
            Scene scene = new Scene(fxmlloader.load());

            stage = new Stage();
            stage.setTitle(company.getCompanyName() + " / Wlasciciel: " + company.getWlasciciel() + " / Działalność: " + company.getRodzajDzialalnosci() );
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnCloseRequest((e)->(secondWindow.exitSecondWindow()));
            stage.setScene(scene);
            stage.show();

        }

    }

    public void getCompanyDetails(){

        companyNameErrorLabel.setText( " Firma:  " + company.getCompanyName() + " / Wlasciciel: " + company.getWlasciciel() + " / Działalność: " + company.getRodzajDzialalnosci());
    }
}