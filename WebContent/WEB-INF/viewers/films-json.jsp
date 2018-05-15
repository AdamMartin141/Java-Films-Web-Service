<%@ page trimDirectiveWhitespaces="true" %>
<%@ page import="baseAndTesterClasses.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.*" %>
<%@ page import="com.google.gson.Gson" %>
<%


ArrayList<Film> allFilms = (ArrayList<Film>) request.getAttribute("films");

Gson gson = new Gson();

String jsonFilms = gson.toJson(allFilms);
response.getWriter().println(jsonFilms);
%>