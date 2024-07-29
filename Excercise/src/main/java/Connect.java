import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect {
	private String connectionString;
	private String user;
	private String pwd;
	private Connection conn = null;

	public Connect(){
		connectionString = "jdbc:oracle:thin:@localhost/ORCL1";
		user = "system";
		pwd = "1";
	}

	public Connection openConnect() throws SQLException {
		conn = DriverManager.getConnection(connectionString, user, pwd);
		return conn;
	}

	public void closeConnect() throws SQLException {
		if( conn != null ) {
			conn.close();
		}
	}

	public Connection getConn(){
		return conn;
	}
}
