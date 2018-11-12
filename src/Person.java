/**
 * Created by p4e-ba6-u1 on 05.11.18.
 */
public class Person {
    int personId;
    String name;
    char sex;

    public Person(int personId, String name, char sex) {

        this.personId = personId;
        this.name = name;
        this.sex = sex;
    }

    public Person() {

    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


}
