import java.sql.Connection;
import java.sql.*;
public class connector {
    public static final String Driver = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/t1809e";
    public static final String DB_User = "root";
    public static final String DB_Pass = "";

    public Connection conn;
// tạo 1 connector duy nhất để dùng mọi lơi
    private static connector instance;

    public static connector getInstance(){
        if (instance == null){
            instance = new connector();
        }
        return instance;
    }
//-------------------------------
    private connector(){
    try {
        Class.forName(Driver);
        this.conn = DriverManager.getConnection(DB_URL,DB_User,DB_Pass);
    }catch (Exception E){}
}

    public ResultSet getQuery(String sql) throws Exception{
        Statement st = conn.createStatement();
        return st.executeQuery(sql);
    }

    public int updateQuery(String sql) throws Exception{
        Statement st = conn.createStatement();
        return st.executeUpdate(sql);
    }


}
