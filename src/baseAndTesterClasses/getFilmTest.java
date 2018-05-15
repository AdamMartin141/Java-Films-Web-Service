package baseAndTesterClasses;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * The 'getFilmTest' public class can be used to test the 'getFilm' FilmDAO method, by calling it within a main method.
 * When the method is run, it prints an ArrayList of film database records that match a given input string, 
 * to the console, or throws an SQLException. Results of tests conducted using this method can be used for debugging purposes.      
 * 
 * @throws SQLException
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 * 
 */

public class getFilmTest {

	public static void main(String[] args) {
		
		// Calls getFilm method from the FilmDAO and prints results to the console screen for testing
		FilmDAO dao2 = new FilmDAO();
		ArrayList<Film> searchedFilms = new ArrayList<>();
																	
		String filmSearch = "Testing Update"; // Tells the program which film record to retrieve

		{
			try {
				
				// Tries to call the relevant DAO method
				searchedFilms = dao2.getFilm(filmSearch); // Retrieves the film with the 'title' set above

			// Catches any exceptions	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
