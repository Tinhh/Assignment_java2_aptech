package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
//   public static ArrayList<dongho> dh2 = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("giaodien.fxml"));
        primaryStage.setTitle("DONG HO");
        primaryStage.setScene(new Scene(root, 443, 293));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
