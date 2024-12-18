public class Person {
    //person properties
    private String firstname;
    private String surname;
    private String team;

    //person constructor
    Person(String firstname, String surname, String team) {
        this.firstname = firstname;
        this.surname = surname;
        this.team = team;
    }

    //person getters and setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
