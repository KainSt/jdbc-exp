import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String pass = "sqlrootpassword";
       try {
           Connection connection = DriverManager.getConnection(url, user, pass);
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM country");
           while (resultSet.next()){
               System.out.println(resultSet.getString(1));
           }
           } catch(Exception ex){
            ex.getStackTrace();
           }
    }
}