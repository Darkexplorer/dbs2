/**
 * Created by p4e-ba6-u1 on 05.11.18.
 */
public class MovieCharacter {

    int movCharId, position;
    String character, alias;

    public MovieCharacter(int movCharId, int position, String character, String alias) {
        this.movCharId = movCharId;
        this.position = position;
        this.character = character;
        this.alias = alias;
    }

    public MovieCharacter() {

    }

    public int getMovCharId() {

        return movCharId;
    }

    public void setMovCharId(int movCharId) {
        this.movCharId = movCharId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
