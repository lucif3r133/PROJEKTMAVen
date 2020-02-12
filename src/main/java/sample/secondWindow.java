package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class secondWindow implements Initializable {


    /**
     * ID I DEKLARACJA ELEMENTÓW KTÓRE UŻYWANE SĄ W POSZCZEGÓLNYCH METODACH
     */

    @FXML
    TextField tableNameField, nameField, positionField, idField, ageField, salaryField,
              bonusField, childrenField, deleteidField, bonusAddField, bonusidField,
              editValueField, editIdField;

    @FXML
    Label infoLabel;

    @FXML
    TextArea textArea;

    @FXML
    RadioButton nameRadio, ageRadio, posRadio, childrenRadio, salaryRadio, bonusRadio;


    private String tableName = "";

    public secondWindow() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    /**
     * STATYCZNA METODA ZAMYKAJĄCA PROGRAM
     */
    public static void exitSecondWindow()
    {
        Platform.exit();
        MainController.exit();
    }


    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK ZAMYKAJĄCY PROGRAM
     */
    public void exitSecondWindowButton()
    {
        Platform.exit();
        MainController.exit();
    }


    PracownicyBaza baza = new PracownicyBaza();


    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK TWORZĄCY NOWĄ TABELE I ŁĄCZĄCY DO BAZY
     */
    public void setNewTable(){

        tableName = tableNameField.getText();
        baza.createTable(tableName);
        infoLabel.setText("Stworzono Nowa Tabele: " + tableName );
    }


    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK ŁĄCZĄCY Z BAZĄ I USTAWIAJĄCY NAZWE ISTNIEJĄCEJ TABELI
     */
    public void setETable(){

        tableName = tableNameField.getText();
        infoLabel.setText("Uzywasz Tabeli o nazwie: " + tableName);

    }


    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK WYSWIETLAJĄCY CALEJ OBECNIE POLACZONEJ TABELI
     */
    public void selectFullTable(){

        if(tableName.equals(""))
        {
            infoLabel.setText("Najpierw połącz się lub stwórz nową tabele!");
        }
        else {
            clearTextArea();
            String wynik = baza.selectTable(tableName);
            textArea.setText(wynik);
             }

    }


    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK DODAJĄCY NOWEGO PRACOWNIKA DO BAZY
     */
    public void addPerson () {
        if(tableName.equals(""))
        {
            infoLabel.setText("Najpierw połącz się lub stwórz nową tabele!");
        }
        else {
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
                selectFullTable();
            }
        }

    }

    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK USUWAJĄCY PRACOWNIKA Z BAZY
     */
    public void deletePerson(){
        if(tableName.equals(""))
        {
            infoLabel.setText("Najpierw połącz się lub stwórz nową tabele!");
        }
        else {
            int tempID = Integer.parseInt(deleteidField.getText());
            baza.zwolnijPracownika(tableName, tempID);
            infoLabel.setText("Zwolniono pracownika o id: " + tempID);
            selectFullTable();
        }

    }

    /**
     *  METODA OBSŁUGIWANA PRZEZ PRZYCISK USTAWIAJĄCY PREMIE DLA WYBRANEGO PRACOWNIKA
     */
    public void bonusAccept(){
        if(tableName.equals(""))
        {
            infoLabel.setText("Najpierw połącz się lub stwórz nową tabele!");
        }
        else {
            baza.dajPremie(tableName, Integer.parseInt(bonusidField.getText()), Integer.parseInt(bonusAddField.getText()));
            selectFullTable();
        }

    }

    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK CZYSZCZĄCY TEXTAREA
     */
    public void clearTextArea(){
        textArea.clear();

    }


    /**
     * METODA OBSŁUGIWANA PRZEZ PRZYCISK EDYTUJĄCY WARTOŚCI POSZCZEGÓLNEGO PRACOWNIKA BAZY
     */
    public void editValue(){
        if(tableName.equals(""))
        {
            infoLabel.setText("Najpierw połącz się lub stwórz nową tabele!");
        }
        else {
            String stringValue = null;
            int intValue;
            String editData = null;
            int editId = Integer.parseInt(editIdField.getText());

            if (nameRadio.isSelected()) {
                stringValue = editValueField.getText();
                editData = "NAMELASTNAME";
                baza.akutalizujDane(tableName, editData, editId, stringValue);
            } else if (posRadio.isSelected()) {
                stringValue = editValueField.getText();
                editData = "POSITION";
                baza.akutalizujDane(tableName, editData, editId, stringValue);
            } else if (salaryRadio.isSelected()) {
                intValue = Integer.parseInt(editValueField.getText());
                editData = "SALARY";
                baza.akutalizujDane(tableName, editData, editId, intValue);
            } else if (bonusRadio.isSelected()) {
                intValue = Integer.parseInt(editValueField.getText());
                editData = "BONUS";
                baza.akutalizujDane(tableName, editData, editId, intValue);
            } else if (childrenRadio.isSelected()) {
                intValue = Integer.parseInt(editValueField.getText());
                editData = "CHILDREN";
                baza.akutalizujDane(tableName, editData, editId, intValue);
            } else if (ageRadio.isSelected()) {
                intValue = Integer.parseInt(editValueField.getText());
                editData = "AGE";
                baza.akutalizujDane(tableName, editData, editId, intValue);
            } else {
                infoLabel.setText("Najpierw Wybierz Która Wartość!");
            }

            selectFullTable();
        }
    }

}