package coreservlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseAndTesterClasses.Film;
import baseAndTesterClasses.FilmDAO;


/** 
 * The public 'updateFilm' servlet class sets up a HTTP route for updating an existing film record in the database, 
 * using doGet. The class calls the FilmDAO 'updateFilm' method, and maps its functionality to the '/updateFilm' URL 
 * path. The class enables user-specified film attributes (id, title, year, director, stars, review) to be passed as 
 * parameters, and updates the existing film record based on the given, existing Film ID. 
 * The URL path is '/updateFilm?id=*ID_NUMBER*&title=*TITLE*&year=*YEAR*&director=*DIRECTOR*&stars=*STARS*&review=*REVIEW*'.  
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 */

//Servlet's URL path
@WebServlet("/updateFilm")

public class updateFilm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Utilises doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// Creates a new instance of the FilmDAO
		FilmDAO dao5 = new FilmDAO();
			
		
		// Creates a new film object, and maps the new attributes to URL parameters using the Java Bean constructor
		Film updatedFilm = new Film();

		// Film attributes are linked to relevant URL parameters
		updatedFilm.setID(Integer.parseInt(request.getParameter("id")));
		updatedFilm.setTitle(request.getParameter("title"));
		updatedFilm.setYear(Integer.parseInt(request.getParameter("year")));
		updatedFilm.setDirector(request.getParameter("director"));
		updatedFilm.setStars(request.getParameter("stars"));
		updatedFilm.setReview(request.getParameter("review")); 
		
		
		try {
			
			// Tries to call the relevant DAO method
			dao5.updateFilm(updatedFilm);
			
		// Catch any SQL Exceptions if needed
		} catch (SQLException e) {
			e.printStackTrace();
		}  
		
	}
		
	
	// Utilises doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
