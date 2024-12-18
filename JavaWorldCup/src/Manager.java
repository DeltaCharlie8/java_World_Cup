public class Manager extends Person{
    //manager properties
    private String favouredFormation;
    private double respect;
    private double ability;
    private double knowledge;
    private double belief;

    //manager constructor
    public Manager(String firstname, String surname, String team, String favouredFormation, double respect, double ability, double knowledge, double belief) {
        super(firstname, surname, team);
        this.favouredFormation = favouredFormation;
        this.respect = respect;
        this.ability = ability;
        this.knowledge = knowledge;
        this.belief = belief;
    }

    //manager getters and setters
    public String getFavouredFormation() {
        return favouredFormation;
    }

    public void setFavouredFormation(String favouredFormation) {
        this.favouredFormation = favouredFormation;
    }

    public double getRespect() {
        return respect;
    }

    public void setRespect(double respect) {
        this.respect = respect;
    }

    public double getAbility() {
        return ability;
    }

    public void setAbility(double ability) {
        this.ability = ability;
    }

    public double getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(double knowledge) {
        this.knowledge = knowledge;
    }

    public double getBelief() {
        return belief;
    }

    public void setBelief(double belief) {
        this.belief = belief;
    }
}
