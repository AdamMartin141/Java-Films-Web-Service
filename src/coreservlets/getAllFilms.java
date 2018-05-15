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
 * The public 'getAllFilms' servlet class sets up a HTTP route for getting an ArrayList of all films from the 
 * database, and displaying it in a web browser, using doGet and doPost. The class calls the FilmDAO 'getAllFilms' 
 * method, and maps its functionality to the '/getAllFilms' URL path. The class enables a format string 
 * (text, json or xml) to be passed as a parameter, with each format string directing the user to 1 of 3 JSP output 
 * pages. The URL path is '/getAllFilms?format=*FORMAT*'.  
 *  
 * @author Adam Martin 11021206
 * @version 1.0
 */

//Servlet's URL path
@WebServlet("/getAllFilms")

public class getAllFilms extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// Utilises doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 

		// Creates a new instance of the FilmDAO
		FilmDAO dao = new FilmDAO();
		ArrayList<Film> allFilms = new ArrayList<Film>();

		try {
			
			// Tries to call the relevant DAO method
			allFilms = dao.getAllFilms();

			// Iterates through array list of films
			for (Film f : allFilms) {
				System.out.println(f); // Prints the array list of films to the console screen
			}

			
            // Request the ArrayList of films
			request.setAttribute("films", allFilms);
			
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

	// Utilises doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
