import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.util.ArrayList;

public class userDAO implements Userinterface {
    private static userDAO instance;
    private userDAO(){

    }
    public static userDAO getInstance(){
        if (instance == null){
            instance = new userDAO();
        }
        return instance;
    }
    // sử dụng ở asm 5 java 2
    @Override
    public boolean create(User u) {
        connector cn = connector.getInstance();
        String sql = "INSERT INTO user (username,email,password)" + "VALUES('" + u.getUsername()+"','"+u.getEmail()+"','"+u.getPassword()+"')";
        try {
            if(cn.updateQuery(sql) > 0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public ArrayList<User> getlist() {
//        ArrayList<User> user = new ArrayList<>();
        connector cn = connector.getInstance();
        String sql = "select * from  user" ;
        try {
            ResultSet rs = cn.getQuery(sql);
            ObservableList<User> list = FXCollections.observableArrayList();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User u =  new User(id,username,email,password);
                list.add(u);
//                return User;
            }

        }catch (Exception e){

        }
        return null;
    }

    @Override
    public boolean update(User u) {
        connector cn = connector.getInstance();
        String sql = "UPDATE user SET username = " + u.username + ",password = " + u.password +",email = " + u.email + " WHERE id = '"+ u.id + "'" ;
        try {
            if(cn.updateQuery(sql) > 0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean delete(User u) {
        connector cn = connector.getInstance();
        String sql = "DELETE FROM user WHERE id ='" + u.id + "'";
        try {
            if(cn.updateQuery(sql) > 0){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }

    public User getUser(Integer id){
        String sql = "SELECT * FROM user WHERE id ="+ id;
        connector cn = connector.getInstance();
        try {
            ResultSet rs = cn.getQuery(sql);
            while (rs.next()){
                return new User(rs.getInt("id"),rs.getString("username"),rs.getString("email"),rs.getString("password"));

            }
        }catch (Exception e){

        }
        return null;
    }
}
