package baseAndTesterClasses;

import java.sql.SQLException;


/**
 * The 'updatetFilmTest' public class can be used to test the 'updateFilm' FilmDAO method, by calling it within a main method.
 * When the method is run, it updates an existing film record with a certain Film ID, based on given updated attributes, 
 * and prints confirmation to the console. Alternatively, it can throw an SQLException. Results of tests conducted using 
 * this method can be used for debugging purposes.      
 * 
 * @throws SQLException
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 * 
 */

public class updateFilmTest {

	public static void main(String[] args) {
		
		// Calls updateFilm method from FilmDAO and prints results to the console screen for testing
		FilmDAO dao4 = new FilmDAO();
		      
		        
		// Creates a new film object with an existing Film ID, and test updated attributes, using the Java Bean constructor
		Film updatedFilm = new Film();
		
		updatedFilm.setID(13000);
		updatedFilm.setTitle("Testing Update 2");
		updatedFilm.setYear(2020);
		updatedFilm.setDirector("James Cameron");
		updatedFilm.setStars("Morgan Freeman");
		updatedFilm.setReview("A very, very, successful film");					
					
		try {
			
			// Tries to call the relevant DAO method
			dao4.updateFilm(updatedFilm); // Updates the above-referenced Film object in the database

		// Catches any exceptions	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	
	}

}
