package configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class SysConfigs {

    /* --- Name --- */
    public static final String name_App = "Java Management Project";

    /* --- Database --- */
    private Connection con;
    private final String host = "localhost";
    private final String uname = "root";
    private final String password = "";
    private final String db = "farm_management";

    public Connection getDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + db, uname, password);
    
            return con;
        } catch (Exception e) {

            System.out.println(e);

            return null;
        }
    }

}





