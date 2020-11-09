package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String team;
    private String nationality;
    private String birthdate;
    private int penalties;
    private int assists;
    private int goals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    @Override
    public String toString() {
        return String.format("%-20s", name) + " | " + team + " | G: " + goals + " | A: " + assists + " | P: " + (assists + goals) + " | PIM: " + penalties + " | ";
    }

    @Override
    public int compareTo(Player o) {
        return (this.assists + this.goals) - (o.assists + o.goals);
    }

}
