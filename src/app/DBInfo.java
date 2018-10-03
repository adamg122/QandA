package app;

public class DBInfo {
	
	static String host = "localhost"; 
	
	static String DBname = "qanda";
	static int port = 3306;
	static String mySQLdbURL = "jdbc:mysql://" + host + ":" + port + "/"
			+ DBname + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	static String user = "user";
	static String password = "password";
	
	static String driver = "com.mysql.cj.jdbc.Driver";

	public DBInfo() {

	}

	static String getDBURL() {
		return mySQLdbURL;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	public static String getDriver() {
		return driver;
	}
	
}