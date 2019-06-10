import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import userDAO;
import  java.sql.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Edit implements Initializable {
    public TextField txtusername;
    public TextField txtemail;
    public PasswordField txtpassword;

    public static User useredit;

//    public void update(){
//        String username = txtUsername.getText();
//        String email = txtEmail.getText();
//        String password = txtPassword.getText();
//
//        try {
//            userEdit.setUsername(username);
//            userEdit.setEmail(email);
//            userEdit.setPassword(password);
//            UserDAO ud = UserDAO.getInstance();
//            ud.update(userEdit);
//        } catch (Exception e){}
//
//    }

    public void update(){
        String username = txtusername.getText();
        String email = txtemail.getText();
        String pass = txtpassword.getText();
        try {
            useredit.setUsername(username);
            useredit.setEmail(email);
            useredit.setPassword(pass);
            userDAO ud = userDAO.getInstance();
            ud.update(useredit);
//            User u = new User(null,username,email,pass);
//            userDAO userDAO = userDAO.getInstance();
//            userDAO.update(useredit);
        } catch (Exception e){}


    }

    public void Home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtusername.setText(useredit.getUsername());
        txtemail.setText(useredit.getEmail());
        txtpassword.setText(useredit.getPassword());


    }
    public void goToList() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
}
