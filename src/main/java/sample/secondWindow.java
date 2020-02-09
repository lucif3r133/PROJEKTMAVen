package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

public class secondWindow implements Initializable {


    @FXML
    Button secondWindowClose, addButton;

    @FXML private TableView<Pracownik> tableView;
    @FXML private TableColumn<Pracownik, String> imieCol;
    @FXML private TableColumn<Pracownik, String> stanowiskoCol;
    @FXML private TableColumn<Pracownik, Integer> idCol;
    @FXML private TableColumn<Pracownik, Integer> wiekCol;
    @FXML private TableColumn<Pracownik, Integer> pensjaCol;
    @FXML private TableColumn<Pracownik, Integer> premiaCol;
    @FXML private TableColumn<Pracownik, Integer> liczbaDzieciCol;


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


}
