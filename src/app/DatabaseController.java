package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.DBInfo;

public class DatabaseController {

	
	public ArrayList<Pytanie> getListaPytanTest(){
		ArrayList<Pytanie> listaPytan = new ArrayList<Pytanie>();
		
		Pytanie pytanie = new Pytanie();
		
		pytanie.setId(1);
		pytanie.setTresc("Pytanie testowe jeden");
		pytanie.setIdDodajacego(1);
		pytanie.setNazwaDodajacego("Admin");
		pytanie.setRank(4);
		pytanie.setLiczbaOdpowiedzi(2);
	
		Pytanie pytanie2 = new Pytanie();
		
		pytanie2.setId(2);
		pytanie2.setTresc("Pytanie testowe dwa");
		pytanie2.setIdDodajacego(2);
		pytanie2.setNazwaDodajacego("User");
		pytanie2.setRank(5);
		pytanie2.setLiczbaOdpowiedzi(1);
	

		listaPytan.add(pytanie);

		listaPytan.add(pytanie2);
		
		return listaPytan;
	}
	
	public ArrayList<Pytanie> getListaPytan() {

		ArrayList<Pytanie> listaPytan = new ArrayList<Pytanie>();

		Connection connection;
		Statement statement;
		ResultSet result = null;

		String dbURL = DBInfo.getDBURL();
		String dbuser = DBInfo.getUser();
		String dbpassword = DBInfo.getPassword();

		try {

			Class.forName(DBInfo.getDriver());
		} catch (ClassNotFoundException e) {
			System.out.println("Error. Driver class not found: " + e);
		}

		try {
			connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
		} catch (SQLException e) {
			System.out.println("Error. Connection problem: " + e);
			return listaPytan;
		}

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return listaPytan;
		}

		String searchString = "SELECT * FROM pytania ORDER BY 'id' desc";
		try {
			result = statement.executeQuery(searchString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return listaPytan;
		}

		try {
			while (result.next()) {
				Pytanie pytanie = new Pytanie();
				
				pytanie.setId(result.getInt("id"));
				pytanie.setTresc(result.getString("pytanie"));
				pytanie.setIdDodajacego(result.getInt("iddodajacego"));
				pytanie.setNazwaDodajacego(result.getString("dodal"));
				pytanie.setRank(result.getInt("rank"));
				pytanie.setLiczbaOdpowiedzi(result.getInt("howManyAnswers"));
			

				listaPytan.add(pytanie);
			}
		} catch (SQLException e) {
			System.out.println("Error. Problem reading data: " + e);
			return listaPytan;
		}

		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error. Problem with closing connection: " + e);
			return listaPytan;
		}

		return listaPytan;
	}

}


