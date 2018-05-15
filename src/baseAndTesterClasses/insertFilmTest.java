package baseAndTesterClasses;

import java.sql.SQLException;


/**
 * The 'insertFilmTest' public class can be used to test the 'insertFilm' FilmDAO method, by calling it within a main method.
 * When the method is run, it inserts a film record into the database, based on given parameters, and prints confirmation to the console.
 * Alternatively, it can throw an SQLException. Results of tests conducted using this method can be used for debugging purposes.      
 * 
 * @throws SQLException
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 * 
 */

public class insertFilmTest {

	public static void main(String[] args) {
		
		// Calls insertFilm method from FilmDAO and prints results to the console screen for testing
		FilmDAO dao3 = new FilmDAO();
		int insertResult = 0;
		      
		        
		// Creates a new film object with test attributes, to insert into the database, using the Java Bean constructor
		Film newFilm = new Film();
		
		newFilm.setID(13000);
		newFilm.setTitle("Testing Update");
		newFilm.setYear(2018);
		newFilm.setDirector("Adam Martin");
		newFilm.setStars("Adam Martin");
		newFilm.setReview("A very successful film");				
					
		try {
			
			// Tries to call the relevant DAO method
			insertResult = dao3.insertFilm(newFilm); // Inserts the above-created Film object into the database

		// Catches any exceptions	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	
	}

}
