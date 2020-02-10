package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("MainWindow.fxml"));

        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);

        MainController controller = (MainController) loader.getController();
        controller.setStage(primaryStage);
        primaryStage.setTitle("CompanyAlpha");
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(400);
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);
        //primaryStage.getIcons().add(new Image("icon.jpg"));
        primaryStage.setOnCloseRequest((e)->(MainController.exit()));
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
