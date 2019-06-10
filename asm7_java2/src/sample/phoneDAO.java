package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.phonebook;
import sample.Userinterface;
import sample.connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class phoneDAO implements Userinterface {
    private static phoneDAO instance;
    private phoneDAO(){

    }
    public static phoneDAO getInstance(){
        if (instance == null){
            instance = new phoneDAO();
        }
        return instance;
    }
    // sử dụng ở asm 5 java 2
    @Override
    public boolean create(phonebook u) {
        connector cn = connector.getInstance();
        String sql = "INSERT INTO phonebook (user_id,telephone,status)" + "VALUES('" + u.getUser_id()+"','"+u.getTelephone()+"','"+u.getStatus()+"')";
        try {
            if(cn.updateQuery(sql) > 0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public ArrayList<phonebook> getlist() {
//        ArrayList<User> user = new ArrayList<>();
        connector cn = connector.getInstance();
        String sql = "select * from  user" ;
        try {
            ResultSet rs = cn.getQuery(sql);
            ObservableList<phonebook> list = FXCollections.observableArrayList();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String user_id = rs.getString("user_id");
                String telephone = rs.getString("telephone");
                String status = rs.getString("status");
                phonebook u =  new phonebook(id,user_id,telephone,status);
                list.add(u);
//                return User;
            }

        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean update(phonebook u) {
        connector cn = connector.getInstance();
        String sql = "UPDATE phonebook" + "SET telephone = " + u.telephone + ",status = " + u.status + "WHERE id = '"+ u.id + "'" ;
        try {
            if(cn.updateQuery(sql) > 0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean delete(phonebook u) {
        connector cn = connector.getInstance();
        String sql = "DELETE FROM phonebook WHERE id ='" + u.id + "'";
        try {
            if(cn.updateQuery(sql) > 0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    public phonebook getphonebook(Integer id){
        String sql = "SELECT * FROM user WHERE id ="+ id;
        connector cn = connector.getInstance();
        try {
            ResultSet rs = cn.getQuery(sql);
            while (rs.next()){
                return new phonebook(rs.getInt("id"),rs.getString("user_id"),rs.getString("telephone"),rs.getString("status"));

            }
        }catch (Exception e){

        }
        return null;
    }
}
