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
 * The public 'insertFilm' servlet class sets up a HTTP route for inserting a film record into the database, using doGet. 
 * The class calls the FilmDAO 'insertFilm' method, and maps its functionality to the '/insertFilm' URL path. The class 
 * enables user-specified film attributes (id, title, year, director, stars, review) to be passed as parameters. The URL 
 * path is '/insertFilm?id=*ID_NUMBER*&title=*TITLE*&year=*YEAR*&director=*DIRECTOR*&stars=*STARS*&review=*REVIEW*'.  
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 */

//Servlet's URL path
@WebServlet("/insertFilm")

public class insertFilm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Utilises doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		// Creates a new instance of the FilmDAO
		FilmDAO dao3 = new FilmDAO();
		int insertResult = 0;
			
		
		// Creates a new film object to insert into the database, using the Java Bean constructor
		Film newFilm = new Film();

		// Film attributes are linked to relevant URL parameters
		newFilm.setID(Integer.parseInt(request.getParameter("id")));
		newFilm.setTitle(request.getParameter("title"));
		newFilm.setYear(Integer.parseInt(request.getParameter("year")));
		newFilm.setDirector(request.getParameter("director"));
		newFilm.setStars(request.getParameter("stars"));
		newFilm.setReview(request.getParameter("review")); 
		
		
		try {
			
			// Tries to call the relevant DAO method
			insertResult = dao3.insertFilm(newFilm);
			
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
