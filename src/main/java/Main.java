import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jsk";
        String user = "root";
        String pass = "";
        Map<String, Double> nameCourse = new TreeMap<>();
       try {
           Connection connection = DriverManager.getConnection(url,user,pass);
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery("select course_name, " +
                   "COUNT(student_name) AS number_of_selling, " +
                   "MIN(MONTH(subscription_date)) AS min_month, " +
                   "MAX(MONTH(subscription_date)) AS max_month " +
                   "from purchaselist " +
                   "GROUP BY course_name");

           while (resultSet.next()){
               nameCourse.put(resultSet.getString("course_name"),resultSet.getDouble("number_of_selling")/
                       (resultSet.getInt("max_month")-resultSet.getInt("min_month")+1));
               }
           } catch(Exception ex){
           System.out.println("Ошибка");
            ex.getMessage();
           }

        for (Map.Entry<String,Double> s: nameCourse.entrySet()) {
            String res = String.format("%.2f",s.getValue());
            System.out.println(s.getKey() + "  " + res );
        }
    }
}
