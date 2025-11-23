import java.util.Scanner;
import java.io.*;

public class Main {
    private static final String CREATE_COM = "create";
    private static final String SCHEDULE_COM = "schedule";
    private static final String CANCEL_COM = "cancel";
    private static final String SHOW_COM = "show";
    private static final String TOP_COM = "top";
    private static final String EXIT_COM = "exit";
    private static final String INVALID_COM = "Invalid command";


    //    Reads input line
    public static int readNextInt(Scanner inp){
        int val = inp.nextInt();
        inp.nextLine();
        return val;
    }

    private static void initUsers(Scanner inp){
        int nUsers = readNextInt(inp);
        Users users = new Users(nUsers);
        for (int i = 0; i < nUsers; i++){
            createUsers(inp,users);
        }
    }

    //Creates Users class
    private static void createUsers(Scanner inp, Users users){
        String userName = inp.nextLine(); //check later
        users.addUsers(userName);
    }

    private static void initEvents(Scanner inp){
        int nEvents = readNextInt(inp);
        for (int i = 0; i < nEvents; i++){
            createEvent(inp);
        }
    }

    //Creates Events class
    private static void createEvent(Scanner inp){
        String eventName = inp.next();
        int day = inp.nextInt();
        int sHour = inp.nextInt();
        int eHour = readNextInt(inp);

        Events ev = new Events(eventName,sHour,eHour);
        int nParticipants = readNextInt(inp);
        for (int j = 0; j < nParticipants; j++){
            String pName = inp.next();
            if(j == 0) ev.addProposer(pName);
            if (!checkUser(pName)) j--;
            else checkSchedule(pName,ev);
//                TODO
        }
    }


    private static void executeCommands(Scanner inp) throws FileNotFoundException {
        String fileName = inp.nextLine();
        FileReader file = new FileReader(fileName);
        Scanner inpFile = new Scanner(file);
        String option;
        do {
            option = inpFile.next();
            switch (option) {
                case CREATE_COM -> createScenario(inpFile);
                case SCHEDULE_COM -> scheduleScenario(inpFile);
                case CANCEL_COM -> cancelScenario(inpFile);
                case SHOW_COM -> showScenario(inpFile);
                case TOP_COM -> topScenario(inpFile);
                case EXIT_COM:
                    break;
                default:
                    System.out.println(INVALID_COM);
            }
            inp.nextLine();
        } while (!option.equals(EXIT_COM));
        //execute again with System.in

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inp = new Scanner(System.in);
        initUsers(inp);
        initEvents(inp);
        executeCommands(inp);
        inp.close();
    }
}