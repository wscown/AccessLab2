import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by wscown on 1/25/16.
 */
public class WaxSpec {

    //With
    Wax w1 = new Wax(Waxgroup.BLUE, Snowconditions.EXTRA);
    Wax w2 = new Wax(Waxgroup.GREEN, Snowconditions.SPECIAL);

    @Test
    public void testconstructor(){

        //Then
        Waxgroup wg1 = w1.getWaxGroup();
        Waxgroup wg2 = w2.getWaxGroup();

        Snowconditions sc1 = w1.getSnowCondition();
        Snowconditions sc2 = w2.getSnowCondition();

        assertEquals("Constructor was used to set Waxgroup to BLUE but this was not returned", Waxgroup.BLUE, wg1);
        assertEquals("Constructor was used to set Waxgroup to GREEN but this was not returned", Waxgroup.GREEN, wg2);

        assertEquals("Constructor was used to set Snowcondition to EXTRA but this was not returned", Snowconditions.EXTRA, sc1);
        assertEquals("Waxgroup was set to RED but the getWaxGroup method does not return this", Snowconditions.SPECIAL, sc2);
    }

    @Test
    public void testsetgetWaxGroup() {

        //When
        w1.setWaxGroup(Waxgroup.GREEN);
        w2.setWaxGroup(Waxgroup.RED);

        //Then
        Waxgroup wg1 = w1.getWaxGroup();
        Waxgroup wg2 = w2.getWaxGroup();

        assertEquals("Waxgroup was set to GREEN but the getWaxGroup method does not return this", Waxgroup.GREEN, wg1);
        assertEquals("Waxgroup was set to RED but the getWaxGroup method does not return this", Waxgroup.RED, wg2);
    }

    @Test
    public void testsetgetSnowConditions() {

        //When
        w1.setSnowCondition(Snowconditions.STANDARD);
        w2.setSnowCondition(Snowconditions.EXTRA);

        //Then
        Snowconditions sc1 = w1.getSnowCondition();
        Snowconditions sc2 = w2.getSnowCondition();

        assertEquals("Snowconditions was set to STANDARD but the getSnowCondition method does not return this", Snowconditions.STANDARD, sc1);
        assertEquals("Snowconditions was set to FIRM but the getSnowCondition method does not return this", Snowconditions.EXTRA, sc2);
    }

    @Test
    public void testtoString() {

        //When

        w1.setSnowCondition(Snowconditions.EXTRA);
        w2.setSnowCondition(Snowconditions.SPECIAL);

        w1.setWaxGroup(Waxgroup.BLUE);
        w2.setWaxGroup(Waxgroup.GREEN);

        String test1 = w1.toString();
        String test2 = w2.toString();

        String expected1 = "Waxgroup: BLUE Variety: EXTRA";
        String expected2 = "Waxgroup: GREEN Variety: SPECIAL";

        //Then

        //Check string is not empty
        assertTrue("The toString method returned an empty string", !(test1.isEmpty()));
        assertTrue("The toString method returned an empty string", !(test2.isEmpty()));

        //Check string pointer is not null
        assertTrue("The toString method returned null incorrectly", test1.compareTo(expected1) == 0);
        assertTrue("The toString method returned null incorrectly", test2.compareTo(expected2) == 0);

    }
}