import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;


/**
 * Created by wscown on 1/25/16.
 */
public class WaxFinderSpec {

    @Test
    public void testsetgetTemp(){

        //With
        UserInterface ui = new UserInterface(1);

        int testnumber = 5;

        Integer testInteger = testnumber;

        String testnumnstring = testInteger.toString();

        ByteArrayInputStream in = new ByteArrayInputStream(testnumnstring.getBytes());
        System.setIn(in);

        //When
        ui.setTemp();

        int test = ui.getTemp();

        //Then
        assertEquals("User input for temp was not successfully entered and retrieved using the set/getTemp methods", testnumber, test);
    }

    @Test
    public void testsetgetConditions(){

        //With
        UserInterface ui = new UserInterface(1);

        String testinput = "powder";

        ByteArrayInputStream in = new ByteArrayInputStream(testinput.getBytes());
        System.setIn(in);

        //When
        ui.setConditions();

        String test = ui.getConditions();

        //Then
        assertEquals("User input for conditions was not successfully entered and retrieved using the set/getConditions methods", testinput, test);
    }

    @Test
    public void testsuggestWax(){
        //With
        UserInterface ui = new UserInterface(1);

        //Test output should be
        Wax tester = new Wax(Waxgroup.GREEN, Snowconditions.SPECIAL);

        //When
        Wax test = ui.suggestWax();

        assertEquals("The test case for wax selection did not give the correct wax", tester.toString(), test.toString());
    }
}