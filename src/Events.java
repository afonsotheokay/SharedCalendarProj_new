public class Events {
    private String name;
    private int startHour;
    private int endHour;
    private String proposer;


    public Events(String name,int startHour, int endHour){
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
        this.proposer = "";
    }

    public void addProposer(String name) {this.proposer = name;}

}
