package baseAndTesterClasses;

import java.sql.SQLException;


/**
 * The 'deleteFilmTest' public class can be used to test the 'deleteFilm' FilmDAO method, by calling it within a main method.
 * When the method is run, it deletes a film record from the database, based on a given film id, and prints confirmation to the 
 * console. Alternatively, it can throw an SQLException. Results of tests conducted using this method can be used for 
 * debugging purposes.      
 * 
 * @throws SQLException
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 * 
 */

public class deleteFilmTest {

	public static void main(String[] args) {

		// Calls deleteFilm method from FilmDAO for testing
		FilmDAO dao5 = new FilmDAO();
		boolean deleteResult = false;
		
		int id2 = 17000; // Tells the program which film number record to delete
		
		{

			try {
				
				// Tries to call the relevant DAO method
				deleteResult = dao5.deleteFilm(id2); // Executes the deletion

			// Catches any exceptions	
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}

