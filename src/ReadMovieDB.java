import java.sql.*;
import java.util.*;

public class ReadMovieDB {
	public static void main(String[] args) {
		String selectedmovie = args[0];
		try {
			Connection con = DriverManager.getConnection(
			"jdbc:oracle:thin:@dboracleserv.inform.hs-hannover.de:1521:db01", "p4e-ba6-u1", "Chriss112");
			String movietitle = getMovieTitle(selectedmovie, con);
			int movieyear = getMovieYear(selectedmovie, con);
			ArrayList<String> genres = getGenres(selectedmovie, con);
			System.out.println(movietitle + ", " + movieyear);
			for(String s : genres) {
				System.out.print(s + ", ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes a SQL-Query to the Genre-Database to get the title for the matching movie.
	 * @param selectedmovie arguments from program execution. Should be a Genre-ID
	 * @param con Connection Object that is used to connect to the DB
	 * @return Genre-title as a string
	 * @author Meinhardt
	 * @throws SQLException 
	 */
	public static String getMovieTitle(String selectedmovie, Connection con) throws SQLException {

		String movietitle = null;
		String sql_movietitle = "SELECT title FROM movie WHERE pk_MovieID = ?";
		PreparedStatement stmt_movietitle = con.prepareStatement(sql_movietitle);
		stmt_movietitle.setString(1, selectedmovie);
		ResultSet rs_movietitle = stmt_movietitle.executeQuery();
		while(rs_movietitle.next()) {
			movietitle = rs_movietitle.getString(1);
		}
		return movietitle;
	}
	
	/**
	 * Executes a SQL-Query to the Genre-Database to get the production year for the matching movie.
	 * @param selectedmovie arguments from program execution. Should be a Genre-ID
	 * @param con Connection object that is used to connect tot the DB
	 * @return The year the movie was made as an int
	 * @throws SQLException
	 * @author Meinhardt
	 */
	public static int getMovieYear(String selectedmovie, Connection con) throws SQLException {
		int movieyear = 0;
		String sql_movieyear = "SELECT movie.year FROM movie WHERE movie.PK_MovieID = ?";
		PreparedStatement stmt_movieyear = con.prepareStatement(sql_movieyear);
		stmt_movieyear.setString(1, selectedmovie);
		ResultSet rs_movieyear = stmt_movieyear.executeQuery();
		while(rs_movieyear.next()) {
			movieyear = rs_movieyear.getInt(1);
		}
		return movieyear;
	}
	
	/**
	 * Executes a SQL-Query to the Genre-Database to get a list of genres for the matching movie
	 * @param selectedmovie argument that is given on program execution. Should be a movie ID 
	 * @param con connection object that is used to get a connection to the DB
	 * @return returns an arraylist of Strings with the genres
	 * @throws SQLException
	 * @Author Meinhardt
	 */
	public static ArrayList<String> getGenres(String selectedmovie, Connection con) throws SQLException {
		ArrayList<String> genres = new ArrayList<String>();
		String sql_genres = "SELECT Genre.Genre FROM movie JOIN HasGenre on(movie.pk_MovieID = HasGenre.pk_fk_Movie) "
		+ "JOIN Genre on (Genre.pk_GenreID = HasGenre.pk_fk_Genre) WHERE movie.pk_MovieID = ?";
		PreparedStatement stmt_genres = con.prepareStatement(sql_genres);
		stmt_genres.setString(1, selectedmovie);
		ResultSet rs_genres = stmt_genres.executeQuery();
		while(rs_genres.next()) {
			genres.add(rs_genres.getString(1));
		}
		return genres;
	}
}
