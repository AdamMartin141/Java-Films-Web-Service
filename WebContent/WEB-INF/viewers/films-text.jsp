<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="java.util.*" %>
<%@ page import="baseAndTesterClasses.*"%>
<%


ArrayList<Film> allFilms = (ArrayList<Film>) request.getAttribute("films");

Film aFilm = null;

for (int i=0; i< allFilms.size();i++) {
	
	aFilm = allFilms.get(i);
	
	out.write("#" + aFilm.getID() + "#" + aFilm.getTitle() + "#" + aFilm.getYear() 
	+ "#" + aFilm.getDirector() + "#" + aFilm.getStars() + "#" + aFilm.getReview());

}
%>


