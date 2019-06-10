import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Login  {
    public TextField txtusername;
    public TextField txtpassword;


   public void login(){
            String username = txtusername.getText();
            String password = txtpassword.getText();

            String sql = "SELECT * from user where username=? AND password=?";

            try {
//                connector cn = connector.getInstance();
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/t1809e";
                Connection con = DriverManager.getConnection(url,"root","");
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2,password);
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    goToList();

                }

            }catch (Exception E){}
        }

    public void home() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }

    public void register() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
    public void goToList() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("List.fxml"));
        Main.MainStage.getScene().setRoot(root);
    }
}
