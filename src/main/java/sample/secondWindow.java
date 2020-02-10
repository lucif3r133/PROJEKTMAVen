package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;

public class secondWindow implements Initializable {


    @FXML
    Button secondWindowClose, addButton, setTable, createNewTable, fullTable, deleteButton;

    @FXML
    TextField tableNameField, nameField, positionField, idField, ageField, salaryField, bonusField, childrenField, deleteidField;

    @FXML
    Label infoLabel;

    @FXML private TableView<Pracownik> tableView;
    @FXML private TableColumn<Pracownik, String> imieCol;
    @FXML private TableColumn<Pracownik, String> stanowiskoCol;
    @FXML private TableColumn<Pracownik, Integer> idCol;
    @FXML private TableColumn<Pracownik, Integer> wiekCol;
    @FXML private TableColumn<Pracownik, Integer> pensjaCol;
    @FXML private TableColumn<Pracownik, Integer> premiaCol;
    @FXML private TableColumn<Pracownik, Integer> liczbaDzieciCol;

    private String tableName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public static void exitSecondWindow()
    {
        Platform.exit();
        MainController.exit();
    }


    public void exitSecondWindowButton()
    {
        Platform.exit();
        MainController.exit();
    }


    DataBase baza = new DataBase();


    public void setNewTable(){

        tableName = tableNameField.getText();
        baza.createTable(tableName);
        infoLabel.setText("Stworzono Nowa Tabele: " + tableName );
    }


    public void setETable(){

        tableName = tableNameField.getText();
        infoLabel.setText("Uzywasz Tabeli o nazwie: " + tableName);

    }


    public void selectFullTable(){

        baza.selectTable(tableName);

    }


    public void addPerson () {

        int tempID = Integer.parseInt(idField.getText());
        String tempName = nameField.getText();
        int tempAge = Integer.parseInt(ageField.getText());
        String tempPosition = positionField.getText();
        int tempSalary = Integer.parseInt(salaryField.getText());
        int tempBonus = Integer.parseInt(bonusField.getText());
        int tempChildren = Integer.parseInt(childrenField.getText());

        if (tempID < 0 || tempBonus < 0 || tempSalary < 0 || tempAge < 0 || tempChildren < 0 || tempPosition.equals("") || tempName.equals("")) {
            infoLabel.setText("Najpierw Wprowadź Poprawne Dane!");
        } else {

            baza.dodajPracownika(tableName, tempID, tempName, tempAge, tempSalary, tempPosition, tempChildren, tempBonus);
            infoLabel.setText("Dodano pracownika o id: " + tempID);
        }


    }

    public void deletePerson(){

        int tempID = Integer.parseInt(deleteidField.getText());
        baza.zwolnijPracownika(tableName, tempID);
        infoLabel.setText("Zwolniono pracownika o id: " + tempID );

    }

}



