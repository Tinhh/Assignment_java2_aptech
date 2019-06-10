import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;

public class Register {
    public TextField txtusername;
    public TextField txtemail;
    public PasswordField txtpassword;

    public void Home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public void Login() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public void Register(){
        String username = txtusername.getText();
        String email = txtemail.getText();
        String pass = txtpassword.getText();

        // cach 1 khi co class UserDAO java2 ss7
//        try {
//            User u = new User(null,username,email,pass);
//            UserDAO userDAO = UserDAO.getInstance();
//            userDAO.create(u);
//        }catch (Exception e){
//
//        }

        // cach 2
        String sql = "INSERT INTO user (username,email,password)" + "VALUES('"+ username + "','" + email + "','" + pass+"' )";
        try {
            connector cn = connector.getInstance();
            int number = cn.updateQuery(sql);
            if(number > 0){
                goToList();
            }

        }catch (Exception E){}
    }

    public void goToList() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
}
