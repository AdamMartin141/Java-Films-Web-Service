package coreservlets;
import javax.xml.bind.annotation.*;

import baseAndTesterClasses.Film;

import java.util.*;


// Establishes the root element name for the XML list of films
@XmlRootElement (name = "filmsXML")
@XmlAccessorType (XmlAccessType.FIELD)


/** 
 * The public 'FilmList' class acts as a container for storing the list of film objects in XML format. This class is 
 * called in the 'films-xml' JSP file, which outputs the XML film objects to the browser.  
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 */

public class FilmList {
	
	// An empty FilmList constructor
	public FilmList() {
		
	}
	
	// Establishes the child element name for each individual film record placed within the 'filmsXML' list
	@XmlElement(name="filmRecord")
	
	
	// Creates the list to hold the XML film objects
	public List<Film> allFilms;
	
	
	// Places the XML film objects in the above-created list
	public FilmList(List<Film> filmRecords) {
		
		allFilms = filmRecords;
		
	}
	
}