import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wscown on 1/25/16.
 */
enum Waxgroup {YELLOW, RED, VIOLET, BLUE, GREEN, WHITE}
enum Snowconditions {SPECIAL, STANDARD, EXTRA}

public class WaxFinder {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
    }
}

class UserInterface{

    private int temp;
    private String conditions = "intialised";

    UserInterface(){
        setTemp();
        setConditions();
        printWax(suggestWax());
    }

    //Constructor used just for testing that avoids calling other methods (so they can be testd individually)
    UserInterface(int i){
        temp = 10;
        conditions = "powder";
    }

    int getTemp(){
        return temp;
    }

    String getConditions(){
        return conditions;
    }

    //Set the temperature from the user input
    int setTemp(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the temperature as an integer and press return:");

        temp = sc.nextInt();
        System.out.println("You set the temperature to " + temp);

        return temp;
    }

    //Set conditions from the user input
    String setConditions(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Please enter a valid snow condition (powder, firm, or crusty) and press return:");
            conditions = sc.next().toLowerCase();
            if(conditions.compareTo("powder") == 0 || conditions.compareTo("firm") == 0 || conditions.compareTo("crusty") == 0){
                break;
            }
        }

        System.out.println("You set the snow conditions to " + conditions);

        return conditions;
    }

    //Provide the best choice of wax for the user
    Wax suggestWax(){

        System.out.println("Your best wax option is as follows:");

        if(temp > 38){
            return new Wax(Waxgroup.YELLOW, Snowconditions.STANDARD);
        }else if(temp > 31){
            return suggestConditions(Waxgroup.RED);
        }else if(temp > 26){
            return suggestConditions(Waxgroup.VIOLET);
        }else if(temp > 18){
            return suggestConditions(Waxgroup.BLUE);
        }else if(temp > 5){
            return suggestConditions(Waxgroup.GREEN);
        }else if(temp <= 5){
            return new Wax(Waxgroup.WHITE, Snowconditions.STANDARD);
        }

        return null;
    }

    Wax suggestConditions(Waxgroup w){

        if(conditions.compareTo("powder")==0){
            return new Wax(w, Snowconditions.SPECIAL);
        }else if(conditions.compareTo("firm")==0){
            return new Wax(w, Snowconditions.STANDARD);
        }else if(conditions.compareTo("crusty")==0){
            return new Wax(w, Snowconditions.EXTRA);
        }

        return null;
    }

    //Prints the provided wax to screen
    void printWax(Wax wax){
        System.out.println(wax.toString());
    }
}

class Wax{
    private Waxgroup waxgroup;
    private Snowconditions snowcondition;

    Wax (Waxgroup waxgroup, Snowconditions snowcondition){
        this.waxgroup = waxgroup;
        this.snowcondition = snowcondition;
    }

    void setWaxGroup(Waxgroup waxgroup){
        this.waxgroup = waxgroup;
    }

    void setSnowCondition(Snowconditions snowcondition){
        this.snowcondition = snowcondition;
    }

    Waxgroup getWaxGroup(){
        return waxgroup;
    }

    Snowconditions getSnowCondition(){
        return snowcondition;
    }

    public String toString(){
        return "Waxgroup: " + waxgroup.toString() + " Variety: " + snowcondition.toString();
    }
}
