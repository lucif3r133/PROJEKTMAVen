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

    private String companyName="CompanyName";
    private Boolean czyUstawione=false;

    Stage stage;

    public Stage getStage() { return stage; }

    void setStage(Stage stage) { this.stage = stage; }

    @FXML
    Button exitButton, setCompanyNameButton, secondWindowButton;

    @FXML
    TextField companyNameField;

    @FXML
    Label companyNameLabel, companyNameErrorLabel, startLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startLabel.setText("Podaj nazwe firmy:");
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

    public void setCompanyName() {
        if(companyNameField.getText().equals("")) {
            companyNameErrorLabel.setText("Wprowadź Nazwe Firmy!");
        }
        else
        {
            companyName = companyNameField.getText();
            companyNameLabel.setText("Zarządzaj firmą " + companyName + " z naszą pomocą, dziękujemy za zaufanie!");
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
            stage.setTitle(companyName);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.getIcons().add(new Image("sample/icon.jpg"));
            stage.setOnCloseRequest((e)->(secondWindow.exitSecondWindow()));
            stage.setScene(scene);
            stage.show();
        }

    }


}


