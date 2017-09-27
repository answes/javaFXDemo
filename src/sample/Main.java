package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = Thread.currentThread().getContextClassLoader().getResource("sample/main.fxml");
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("批量下单操作");
        primaryStage.setScene(new Scene(root, 1000, 710));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
