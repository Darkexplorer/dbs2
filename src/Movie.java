import java.sql.Connection;

/**
 * Created by p4e-ba6-u1 on 05.11.18.
 */
public class Movie {
    int movieId,year;
    String title;
    char type;

    public Movie(int movieId, int year, String title, char type) {
        this.movieId = movieId;
        this.year = year;
        this.title = title;
        this.type = type;
    }

    public Movie() {

    }

    public int getMovieId() {

        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void insert(Connection connection) {

    }
}
