/**
 * Created by p4e-ba6-u1 on 05.11.18.
 */
public class Genre {
    private int genreId;
    String genre;

    Genre(int id, String genre) {
        genreId = id;
        this.genre = genre;
    }

    Genre() {

    }

    public void setGenreId(int genreId) {

        this.genreId = genreId;
    }

    public void setGenre(String genre) {

        this.genre = genre;
    }

    public int getGenreId() {

        return genreId;
    }

    public String getGenre() {

        return genre;
    }
}
