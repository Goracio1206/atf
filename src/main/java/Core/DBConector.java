package Core;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Admin on 20-Jun-17.
 */
public class DBConector {
    private Connection connection;

    public DBConector() throws SQLException {
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    public Connection getConnection(String url, String userName, String password) throws SQLException {
        if(connection != null){
            return connection;
        }
        connection = DriverManager.getConnection(url, userName, password);
        return connection;
    }
}
