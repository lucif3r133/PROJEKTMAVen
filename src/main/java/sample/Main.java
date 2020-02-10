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
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(500);
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);
        primaryStage.setMaxHeight(1000);
        primaryStage.setMaxWidth(1200);
        primaryStage.setOnCloseRequest((e)->(MainController.exit()));
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
