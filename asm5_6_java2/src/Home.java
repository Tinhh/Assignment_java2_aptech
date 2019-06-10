import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Home {
    public void login() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public void register() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public void list() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public void exit(){
        Platform.exit();
    }
}
