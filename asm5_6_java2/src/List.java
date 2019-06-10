import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.lang.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class List implements Initializable {

    public TableView<User> tbView;

    public TableColumn<User,Integer> colid;
    public TableColumn<User,String> colusername;
    public TableColumn<User,String> colemail;
    public TableColumn<User,String> colpass;
    public TableColumn<User, Button> coledit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colpass.setCellValueFactory(new PropertyValueFactory<>("password"));
        coledit.setCellValueFactory(new PropertyValueFactory<>("edit"));

        String sql = "select * from  user" ;
        try {
            connector cn = connector.getInstance();
            ResultSet rs = cn.getQuery(sql);
            ObservableList<User> list = FXCollections.observableArrayList();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User u =  new User(id,username,email,password);
                list.add(u);
                u.updatebutton();
            }
            tbView.setItems(list);

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

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//    }
}
