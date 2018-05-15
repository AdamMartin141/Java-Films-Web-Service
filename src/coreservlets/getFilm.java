package coreservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseAndTesterClasses.Film;
import baseAndTesterClasses.FilmDAO;


/** 
 * The public 'getFilm' servlet class sets up a HTTP route for getting an ArrayList of films with a title that matches
 * a given title input string, and displaying it in a web browser, using doGet and doPost. The class calls the FilmDAO 
 * 'getFilm' method, and maps its functionality to the '/getFilm' URL path. The class enables 2 parameters to be passed,
 * which consist of a 'film title/ name' string, and a format string (text, json or xml). Each format string directs 
 * the user to 1 of 3 JSP output pages. The URL path is '/getFilm?title=*TITLE*&format=*FORMAT*'.  
 *  
 * @author Adam Martin 11021206
 * @version 1.0
 */

//Servlet's URL path
@WebServlet("/getFilm")

public class getFilm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Utilises doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				 
		// Creates a new instance of the FilmDAO
		FilmDAO dao = new FilmDAO();
		ArrayList<Film> searchedFilms = new ArrayList<>();

		// Links the passed title value to the 'title' URL parameter
		String filmSearch = request.getParameter("title");

		{
			try {
				
				// Tries to call the relevant DAO method
				searchedFilms = dao.getFilm(filmSearch); // Retrieves the film with the 'title' set above
		
	            // Request the ArrayList of films
				request.setAttribute("films", searchedFilms);
				
				// Links the passed format value to the 'format' URL parameter
				String format = request.getParameter("format");
				String outputPage;

				
				// If 'xml' is passed as the format, direct user to XML JSP
				if ("xml".equals(format)) {
					response.setContentType("text/xml");
					outputPage = "/WEB-INF/viewers/films-xml.jsp";
					
				// If 'json' is passed as the format, direct user to JSON JSP	
				} else if ("json".equals(format)) {
					response.setContentType("application/json");
					outputPage = "/WEB-INF/viewers/films-json.jsp";
					
				// If anything else if passed as the format (text), direct user to TEXT JSP
				} else {
					response.setContentType("text/plain");
					outputPage = "/WEB-INF/viewers/films-text.jsp";
				}

				RequestDispatcher dispatcher = // Where do you want to go? Let's go there with the request you have
						request.getRequestDispatcher(outputPage);
				dispatcher.include(request, response);

			// Catch any SQL Exceptions if needed
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// Utilises doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}