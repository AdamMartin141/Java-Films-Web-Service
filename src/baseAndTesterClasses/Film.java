package baseAndTesterClasses;

import java.io.Serializable;

import javax.xml.bind.annotation.*;




/**
 * The Film public base class establishes the attributes of a Film (id, title, year, director, stars, review), and 
 * sets and gets its values. All of the attributes are of type String, apart from id (int) and year (int). The class
 * contains 2 constructors, a 'Java Bean', that uses getters and setters to get and set attributes, and a normal constructor,
 * which uses named attribute parameters. These constructors construct film objects for the database. 
 * 
 * @author Adam Martin 11021206
 * @version 1.0
 * 
 */

@XmlRootElement (name = "films")
@XmlAccessorType (XmlAccessType.FIELD)

public class Film implements Serializable {

	
	private static final long serialVersionUID = 1L;


	/** 
	 * The empty 'Java Bean' constructor uses setters and getters to to get and set attributes, and construct film 
	 * objects
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public Film() {
		
	}
	
	public int id;
	public String title;
	public int year;
	public String director;
	public String stars;
	public String review;
	
	
	/** 
	 * The Film public constructor constructs a film object using named parameters (id, title, year, director, stars, review).
	 *  
	 * @param id, title, year, director, stars, review
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public Film(int id, String title, int year, String director, String stars, String review) {
		
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.stars = stars;
		this.review = review;
	}

	
	// 'Setter and Getter' methods to get and return values

		
	/** 
	 * This film 'getter' gets the film's id number. 
	 * 
	 * @return the film's id number
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public int getID() {
		return id;
	}

	
	/**
	 * This film 'setter' sets the film's id number.
	 * 
	 * @param id
	 *  
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public void setID(int id) {
		this.id = id;
	}

	
	/** 
	 * This film 'getter' gets the film's title. 
	 * 
	 * @return the film's title
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public String getTitle() {
		return title;
	}

	
	/**
	 * This film 'setter' sets the film's title.
	 * 
	 * @param title
	 *  
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}

	
	/** 
	 * This film 'getter' gets the film's year. 
	 * 
	 * @return the film's year
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public int getYear() {
		return year;
	}

	
	/**
	 * This film 'setter' sets the film's year.
	 * 
	 * @param year
	 *  
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public void setYear(int year) {
		this.year = year;
	}

	
	/** 
	 * This film 'getter' gets the film's director. 
	 * 
	 * @return the film's year
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public String getDirector() {
		return director;
	}

	
	/**
	 * This film 'setter' sets the film's director.
	 * 
	 * @param director
	 *  
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public void setDirector(String director) {
		this.director = director;
	}

	
	/** 
	 * This film 'getter' gets the film's stars. 
	 * 
	 * @return the film's stars
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public String getStars() {
		return stars;
	}

	
	/**
	 * This film 'setter' sets the film's stars.
	 * 
	 * @param stars
	 *  
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public void setStars(String stars) {
		this.stars = stars;
	}

	
	/** 
	 * This film 'getter' gets the film's review. 
	 * 
	 * @return the film's review
	 * 
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public String getReview() {
		return review;
	}

	
	/**
	 * This film 'setter' sets the film's review.
	 * 
	 * @param stars
	 *  
	 * @author Adam Martin
	 * @version 1.0
	 */
	
	public void setReview(String review) {
		this.review = review;
	}
	
	
	
	/** 
	 * This toString() method puts all of the 'Film' attributes in a string, to avoid the Film being outputted
	 * as byte code.
	 * 
	 * @author Adam Martin
	 * @version 1.0 
	 * 
	 */
	
	public String toString()
	{
		return "Film ID: " + this.getID() + " Title: "+this.getTitle() +
				" Year: "+this.getYear()+" Director: "+this.getDirector() +
				" Stars: " + this.getStars() + " Review: "+this.getReview();				
	}
	
}