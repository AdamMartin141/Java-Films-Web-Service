package baseAndTesterClasses;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * The 'getAllFilmsTest' public class can be used to test the 'getAllFilms' FilmDAO method, by calling it within a main method.
 * When the method is run, it prints an ArrayList of all film database records to the console, or throws an SQLException.
 * Results of tests conducted using this method can be used for debugging purposes.      
 * 
 * @throws SQLException
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 * 
 */

public class getAllFilmsTest {

	public static void main(String[] args) {

		// Calls getAllFilms method from the FilmDAO and prints results to the console screen for testing
		FilmDAO dao = new FilmDAO();
		ArrayList<Film> allFilms = new ArrayList<>();

		try {
			
			// Tries to call the relevant DAO method
			allFilms = dao.getAllFilms(); // Calls the method from the FilmDAO

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Iterates through array list of films
		for (Film f : allFilms) {
			System.out.println(f); // Prints the array list of films to the console screen
		}

	}

}
