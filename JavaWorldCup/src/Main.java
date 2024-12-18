import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Squad[] squads = new Squad[32];

    public static void main(String[] args){
        //creates an arrayList of all the players
        ArrayList<Player> playersList = new ArrayList<>();
        Scanner in = null;
        String[] fields;
        try{
            File allPlayers = new File("C:\\Users\\debbi\\OneDrive\\Documents\\GOLDSMITHS\\Year 2\\Java for Industry\\JavaWorldCup\\JavaWorldCup\\Players.csv");
            in = new Scanner(allPlayers); //reads the document which contains all the players
            in.nextLine(); //skips the first line which is the header
            while(in.hasNext()){
                String line = in.nextLine(); //reads each line
                fields = line.split("\\,"); //splits the line into separate data items

                //assigns the variables in the constructor to each data item
                String firstname = fields[0];
                String surname = fields[1];
                String team = fields[2];
                String position = fields[3];
                double fitness = Double.parseDouble(fields[4]);
                double passingAccuracy = Double.parseDouble(fields[5]);
                double shotAccuracy = Double.parseDouble(fields[6]);
                double shotFrequency = Double.parseDouble(fields[7]);
                double defensiveness = Double.parseDouble(fields[8]);
                double aggression = Double.parseDouble(fields[9]);
                double positioning = Double.parseDouble(fields[10]);
                double dribbling = Double.parseDouble(fields[11]);
                double chanceCreation = Double.parseDouble(fields[12]);
                double offsideAdherence = Double.parseDouble(fields[13]);

                Player player = new Player(firstname, surname, team, position, fitness, passingAccuracy, shotAccuracy, shotFrequency, defensiveness, aggression, positioning, dribbling, chanceCreation, offsideAdherence);
                playersList.add(player); //adds the current player to the player list

            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }finally {
            if(in != null){
                in.close();
            }
        }


        //creates an arrayList of all the managers
        ArrayList<Manager> managersList = new ArrayList<>();
        Scanner in2 = null;
        String[] fields2;
        try{
            File allManagers = new File("C:\\Users\\debbi\\OneDrive\\Documents\\GOLDSMITHS\\Year 2\\Java for Industry\\JavaWorldCup\\JavaWorldCup\\Managers.csv");
            in2 = new Scanner(allManagers); //reads the document which contains all the players
            in2.nextLine(); //skips the first line which is the header
            while(in2.hasNext()){
                String line = in2.nextLine(); //reads each line
                fields2 = line.split("\\,"); //splits the line into separate data items

                //assigns the variables in the constructor to each data item
                String firstname = fields2[0];
                String surname = fields2[1];
                String team = fields2[2];
                String favouredFormation = fields2[3];
                double respect = Double.parseDouble(fields2[4]);
                double ability = Double.parseDouble(fields2[5]);
                double knowledge = Double.parseDouble(fields2[6]);
                double belief = Double.parseDouble(fields2[7]);

                Manager manager = new Manager(firstname,surname, team, favouredFormation, respect, ability, knowledge, belief);
                managersList.add(manager); //adds the current manager to the manager list
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }finally {
            if(in != null){
                in.close();
            }
        }


        //adds a new squad to the squads array
        for(int i = 0; i < managersList.size(); i++){
            Squad s = new Squad(managersList.get(i).getTeam(), managersList.get(i));
            //adds all the matching players for the current team
            for(int j = 0; j < playersList.size(); j++){
                if(playersList.get(j).getTeam() == managersList.get(i).getTeam()){
                    s.addPlayer(playersList.get(j));
                }
            }
            squads[i] = s;

            //creates a new team with the managers favoured formation
            getTeam(s);
        }
        }
    }

    public static Team getTeam(Squad s){
        Team t = new Team(s.getTeamName(), s.getManager());
        // get the numerical value of each formation
        int[] formation = {0,0,0};
        String a = String.valueOf((s.getManager().getFavouredFormation().charAt(0)));
        String b = String.valueOf((s.getManager().getFavouredFormation().charAt(2)));
        String c = String.valueOf((s.getManager().getFavouredFormation().charAt(4)));
        formation[0] = Integer.parseInt(a);
        formation[1] = Integer.parseInt(b);
        formation[2] = Integer.parseInt(c);
        for(int i = 0; i < 25; i++){
            int d = 0;
            int e = 0;
            int f = 0;
            int g = 0;
            //then do a loop over each player
            //and add the no. of players according to formation
            if(d < formation[0]) {
                if(s.getPlayer(i).getPosition() == "Defender"){
                    t.addPlayer(s.getPlayer(i));
                    d++;
                }
            }
            if(e < formation[1]) {
                if(s.getPlayer(i).getPosition() == "Midfielder"){
                    t.addPlayer(s.getPlayer(i));
                    e++;
                }
            }
            if(f < formation[0]) {
                if(s.getPlayer(i).getPosition() == "Forward"){
                    t.addPlayer(s.getPlayer(i));
                    f++;
                }
            }
            if(g < 1) {
                if(s.getPlayer(i).getPosition() == "Goal Keeper"){
                    t.addPlayer(s.getPlayer(i));
                    g++;
                }
            }
        }
        return t;
    }

    public static void runTournament(){

    }
}