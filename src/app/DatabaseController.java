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

	public ArrayList<Odpowiedz> getListaOdpowiedzi(int idPytania) {

		ArrayList<Odpowiedz> listaOdpowiedzi = new ArrayList<Odpowiedz>();

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
			return listaOdpowiedzi;
		}

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return listaOdpowiedzi;
		}

		String searchString = "SELECT * FROM odpowiedzi WHERE idp =" + idPytania + " ORDER BY ranks DESC;";
		try {
			result = statement.executeQuery(searchString);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return listaOdpowiedzi;
		}

		try {
			while (result.next()) {

				Odpowiedz odp = new Odpowiedz();

				odp.setIdPytanie(result.getInt("idp"));
				odp.setId(result.getInt("id"));
				odp.setTresc(result.getString("odpowiedz"));
				odp.setIdDodajacego(result.getInt("idUser"));
				// odp.setNazwaDodajacego(result.getString("dodal"));
				odp.setRank(result.getInt("ranks"));
				odp.setLiczbaKomentarzy(result.getInt("howManyComments"));

				listaOdpowiedzi.add(odp);

			}
		} catch (SQLException e) {
			System.out.println("Error. Problem reading data: " + e);
			return listaOdpowiedzi;
		}

		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error. Problem with closing connection: " + e);
			return listaOdpowiedzi;
		}

		return listaOdpowiedzi;
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

		String searchString = "SELECT * FROM pytania";
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
				pytanie.setRank(result.getInt("ranks"));
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

	public void sendQuery(String query) {
		Connection connection;
		Statement statement;
		
		String dbURL = DBInfo.getDBURL();
		String dbuser = DBInfo.getUser();
		String dbpassword = DBInfo.getPassword();
		
		try {

			Class.forName(DBInfo.getDriver());
		} catch (ClassNotFoundException e) {
			System.out.println("Error. Driver class not found: " + e);
			return;
		}
		
		try {
			connection = DriverManager.getConnection(dbURL, dbuser, dbpassword);
		} catch (SQLException e) {
			System.out.println("Error. Connection problem: " + e);
			return;
		}

		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error. Can not create the statement: " + e);
			return;
		}
		
		try {
			statement.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Error. Problem with executeUpdate: " + e);
			return ;
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Error. Problem with closing connection: " + e);
			return ;
		}
	}
	
	
	public ArrayList<Pytanie> getListaPytanTest() {
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

	public ArrayList<Odpowiedz> getListaOdpowiedziTest(int idPytania) {
		ArrayList<Odpowiedz> listaOdpowiedzi = new ArrayList<Odpowiedz>();

		Odpowiedz odp = new Odpowiedz();

		odp.setId(1);
		odp.setIdPytanie(1);
		odp.setTresc("Odpowiedz do pytania jeden");
		odp.setIdDodajacego(1);
		odp.setNazwaDodajacego("user");
		odp.setRank(4);
		odp.setLiczbaKomentarzy(2);

		Odpowiedz odp2 = new Odpowiedz();

		odp2.setId(2);
		odp2.setIdPytanie(2);
		odp2.setTresc("Odpowiedz do pytania dwa");
		odp2.setIdDodajacego(2);
		odp2.setNazwaDodajacego("admin");
		odp2.setRank(3);
		odp2.setLiczbaKomentarzy(1);

		if (idPytania == odp.getIdPytania()) {
			listaOdpowiedzi.add(odp);
		}
		if (idPytania == odp2.getIdPytania()) {
			listaOdpowiedzi.add(odp2);
		}

		return listaOdpowiedzi;
	}

}
