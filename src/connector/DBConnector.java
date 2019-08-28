package connector;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnector {
	
	public static String url = "jdbc:oracle:thin:@localhost:1521/orcl.rev.global.pvt";
	public static String user = "JDE";
	public static String password = "jde01";
	//Connection con = DriverManager.getConnection(url,user,password);
	 public static Connection connect() {
         Connection connection = null;
         if (connection != null)
         {
               return connection;
         }
         try {
                    
        		Class.forName("oracle.jdbc.OracleDriver");
                connection = DriverManager.getConnection(url,user,password);
         } catch (Exception e) {
               e.printStackTrace();
         }
         return connection;
   }
}
