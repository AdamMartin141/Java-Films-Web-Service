package baseAndTesterClasses;

import java.util.ArrayList;
import java.sql.*;


/**
 * The FilmDAO public class contains a range of public methods, which can be called by other classes for CRUD. When called, 
 * these methods connect to the database, get all film records from the database, get a single film record from the 
 * database, insert a film record into the database, and delete a film record from the database.  
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 * 
 */

public class FilmDAO {

	// DAO variables
	Film oneFilm = null;
	Connection conn = null;
	Statement stmt = null;

	
	
	/**
	 * The public getConnection class connects to the JDBC driver, and then to the MySQL films database, which passes
	 * through the 'Mudfoot' server. This enables the program to manipulate the data in this database. If the connection is 
	 * successful, the method returns the database connection. Otherwise, the method throws an SQLException.
	 * 
	 * @return dbConnection
	 * @throws SQLException
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	// Method for getting the database connection
	public Connection getConnection() {

		// Creates the value to be returned
		Connection dbConnection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver"); // Links to the mysql JDBC driver file on the build path

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			// MySQL database connection URL (The database passes through the Mudfoot server)
			String dbURL = ("jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/martina?user=martina&password=Ongeryol2");
																													
			dbConnection = DriverManager.getConnection(dbURL);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	
	
	
	/**
	 * The public getAllFilms method connects to the database using the getConnection method, and then uses an SQL 
	 * statement to obtain all records from the 'films' database table. These records are then placed in array list. 
	 * When the method has been called successfully, it prints confirmation to the console screen. 
	 * Otherwise, the method throws an SQLException. 
	 * 
	 * @return allFilms
	 * @throws SQLException
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	// Method for getting an array list of all Film records contained in the database
	public ArrayList<Film> getAllFilms() throws SQLException {

		// Creates the value to be returned
		ArrayList<Film> allFilms = new ArrayList<Film>();

		Connection connection = null;
		Statement statement = null;
		Film theFilm = null;
		String query = "SELECT * FROM films;";
		ResultSet resultset = null;

		try { // Opens the database connection by calling the getConnection method
			connection = getConnection();
			connection.setAutoCommit(false);

			// Console output for users
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Get All Films - Database successfully opened");

			// Executes the SQL statement
			statement = connection.createStatement();
			System.out.println("SQL Statement: " + query);
			System.out.println("Get All Films - Records successfully located");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("Get All Films - Records:");
			System.out.println();
			resultset = statement.executeQuery(query);

			// Adds the table columns to the result set
			while (resultset.next()) {

				// Constructs a blank film to add to the result list
				theFilm = new Film();

				// Sets the films' values using base class setters and database columns
				theFilm.setID(resultset.getInt("id"));
				theFilm.setTitle(resultset.getString("title"));
				theFilm.setYear(resultset.getInt("year"));
				theFilm.setDirector(resultset.getString("director"));
				theFilm.setStars(resultset.getString("stars"));
				theFilm.setReview(resultset.getString("review"));

				allFilms.add(theFilm);
			}

			// Closes the result set and catches any exceptions
			resultset.close();
			statement.close();
			connection.commit();
			connection.close();

		// Catches any exceptions	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return allFilms;
	}

	
	
	
	/**
	 * The public getFilm method connects to the database using the getConnection method, and then uses an SQL 
	 * statement to search the database for films with titles that match an input string. These records are then placed in array list. 
	 * When the method has been called successfully, it prints confirmation to the console screen. Otherwise, the method throws 
	 * an SQLException. 
	 * 
	 * @param filmTitle
	 * @return filmsArray
	 * @throws SQLException
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */	
		
	// Method for getting an array list of Film records that match the string parameter passed
	public ArrayList<Film> getFilm(String filmTitle) throws SQLException {

		// Creates the value to be returned
		ArrayList<Film> filmsArray = new ArrayList<Film>();

		Connection connection = null;
		Statement statement = null;
		Film tempFilm = null;
		
		// Gets a film based on a given name ('LIKE' is used to render the search flexible)
		String query = "SELECT * FROM films WHERE title LIKE '%" + filmTitle + "%'"; 
		ResultSet resultset = null;

		try { // Opens the database connection by calling the getConnection method
			connection = getConnection();
			connection.setAutoCommit(false);

			// Console output for users
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("Get Film - Database successfully opened");

			// Executes the SQL statement
			statement = connection.createStatement();
			System.out.println("SQL Statement: " + query);
			System.out.println("Get Film - Record successfully located");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("Get Film(s) by Title - Record(s):");
			System.out.println();
			resultset = statement.executeQuery(query);

			// Adds the table columns to the result set
			for (; resultset.next(); filmsArray.add(tempFilm)) {

				// Constructs a blank film to add to the result list
				tempFilm = new Film();

				// Sets the films' values using base class setters and database columns
				tempFilm.setID(resultset.getInt("id"));
				tempFilm.setTitle(resultset.getString("title"));
				tempFilm.setYear(resultset.getInt("year"));
				tempFilm.setDirector(resultset.getString("director"));
				tempFilm.setStars(resultset.getString("stars"));
				tempFilm.setReview(resultset.getString("review"));

				// Prints the chosen Film record(s) to the console, for debugging/ testing
				System.out.println("Film Record: " + tempFilm);

			}

			// Closes the result set and catches any exceptions
			resultset.close();
			statement.close();
			connection.commit();
			connection.close();

		// Catches any exceptions	
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return filmsArray;
	}

	
	
	
	/**
	 * The public insertFilm method connects to the database using the getConnection method, and then uses an SQL 
	 * statement to insert a film record into the 'films' database table. When the method has been called 
	 * successfully, it prints confirmation to the console screen, and indicates the number of records inserted, 
	 * which is the method's return value. Otherwise, the method throws an SQLException. 
	 * 
	 * @param film
	 * @return numberInserted
	 * @throws SQLException
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	// Method for inserting a film record into the database
	public int insertFilm(Film film) throws SQLException {
		
		{

			// Creates the value to be returned
			int numberInserted = 0;
			
			Connection connection = null;
			Statement statement = null;
			
			// Inserts a film by calling getters and setters from the Films class
			String query = "INSERT INTO films (id, title, year, director, stars, review) " + "VALUES ('" + film.getID()
					+ "','" + film.getTitle() + "','" + film.getYear() + "','" + film.getDirector() + "','"
					+ film.getStars() + "','" + film.getReview() + "')"; 

			try {
				// Opens the database connection by calling the getConnection method
				connection = getConnection();
				connection.setAutoCommit(false);

				System.out.println("");
				System.out.println(
						"-----------------------------------------------------------------------------------------------");
				System.out.println("Insert Film - Database successfully opened");

				// Executes the SQL statement
				statement = connection.createStatement();
				System.out.println("SQL Statement: " + query);
				numberInserted = statement.executeUpdate(query);

				// Closes the result set and catches any exceptions
				statement.close();
				connection.commit();
				connection.close();

			// Catches any exceptions	
			} catch (Exception ex) {
				System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
				System.exit(0);
			}

			// Console output for users
			System.out.println("Insert Film - Record successfully created");
			System.out.println("Insert Film - Number of Film records added: " + numberInserted);
			System.out.println(
					"-----------------------------------------------------------------------------------------------");

			return numberInserted;
		}
	}


	
	
	/**
	 * The public updateFilm method connects to the database using the getConnection method, and then uses an SQL 
	 * statement to update attributes of a film record in the 'films' database table, based on a given Film ID. 
	 * When the method has been called successfully, it prints confirmation to the console screen. Otherwise, the 
	 * method throws an SQLException. 
	 * 
	 * @param updFilm
	 * @return updateResult
	 * @throws SQLException
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */	
	
	public Boolean updateFilm(Film updFilm) throws SQLException {
		{
			
    Boolean updateResult = false;	
    Connection connection = null;
    Statement statement = null;
	String query = "UPDATE films SET title = '" + updFilm.getTitle()+"', "
			+ "year = '" + updFilm.getYear() + "', director = '" + updFilm.getDirector() + "', stars = '" + updFilm.getStars()+"', "
			+ "review = '" + updFilm.getReview() + "'" + "WHERE id = '" + updFilm.getID() + "'";; // Updates an employee assigned to a certain employee number. Calls 'getters' from Person and Employee classes to assign values
    
    try {
		// Opens the database connection by calling the getDBConnection method
		connection = getConnection();	
		connection.setAutoCommit(false);
		
		// Console output for users
		System.out.println();	
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("Update Film - Database successfully opened");
		    
		// Executes the SQL statement
		statement = connection.createStatement();
		System.out.println("SQL Statement: "+query);
		statement.executeUpdate(query);
		
		// Closes the result set and catches any exceptions
		connection.commit();
		statement.close();
		connection.close();
		
		} catch ( Exception e ) {
		    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
	    }
    
            // Console output for users
		    System.out.println("Update Film - Record successfully updated");
		    System.out.println("--------------------------------------------------------------------------------------------------------------");
		    
	    return updateResult;
	    }
     }
	
	
	
	
	/**
	 * The public deleteFilm method connects to the database using the getConnection method, and then uses an SQL 
	 * statement to delete an film with a specific 'id' from the 'films' database table. When the method has been called 
	 * successfully, it prints confirmation to the console screen. Otherwise, the method throws an SQLException. 
	 * 
	 * @param id
	 * @return deleteResult
	 * @throws SQLException
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	// Method for deleting a film record from the database
	public Boolean deleteFilm(int id) throws SQLException {
		
		{
			// Creates the value to be returned
			Boolean deleteResult = false;
			
			Connection connection = null;
			Statement statement = null;
			
			// Deletes a film with a given 'id'
			String query = "DELETE FROM films WHERE id = '" + id + "'";
																		
			try {
				// Opens the database connection by calling the getConnection method
				connection = getConnection();
				connection.setAutoCommit(false);

				// Console output for users
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Delete Film - Database successfully opened");

				// Executes the SQL statement
				statement = connection.createStatement();
				System.out.println("SQL Statement: " + query);
				statement.executeUpdate(query);

				// Closes the result set and catches any exceptions
				connection.commit();
				statement.close();
				connection.close();

			// Catches any exceptions	
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}

			// Console output for users
			System.out.println("Delete Film - Record successfully deleted");
			System.out.println("--------------------------------------------------------------------");

			return deleteResult;
		}

	}
}