package coreservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseAndTesterClasses.FilmDAO;


/** 
 * The public 'deleteFilm' servlet class sets up a HTTP route for deleting a film record from the database, using doGet. 
 * The class calls the FilmDAO 'deleteFilm' method, and maps its functionality to the '/deleteFilm' URL path. 
 * The class enables a user-specified id number to be passed as a parameter, in order for a specific film record 
 * to be deleted. The URL path is '/deleteFilm?id=*ID_NUMBER*'.  
 * 
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 */

// Servlet's URL path
@WebServlet("/deleteFilm")

public class deleteFilm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Utilises doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// Creates a new instance of the FilmDAO
		FilmDAO dao5 = new FilmDAO();
		boolean deleteResult = false;
			
		// Links the passed id value to the 'id' database column
		int id1 = Integer.parseInt(request.getParameter("id"));  // Tells the program which film number record to delete		
			
		{

			try { 
				
				// Attempts the deletion
				deleteResult = dao5.deleteFilm(id1);

			// Throws an SQLException if errors occur
			} catch (SQLException ex) {
				ex.printStackTrace(); 
			}
			
		}
		
	}

}
			