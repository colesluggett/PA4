/*
 * Authors: Cole Sluggett, John Dickson, Zachariah Fahsi
 * Date: 4/20/18
 * Overview: Solves the change making problem using a dynamic
 *           programming algorithm.
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PA4Test {
    
    @Test
    void makeChangeWithEmptyArray() {   //test for empty array
        int array[] = {};
        Exception e = assertThrows(IllegalArgumentException.class, () -> {  PA4.getChange(array,20); } );
        assertEquals("Array of size 0 is not allowed", e.getMessage());
    }

    @Test
    void getChangeWith0AsChange() {     //test for 0 as change
        ArrayList<Integer> ans = new ArrayList<>();
        int array[] = {1,5,10,25};
        assertEquals(ans,PA4.getChange(array,0));
    }
    @Test
    void getChangeWithOnlineEx42() {    //tests for online example with 42
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(1);arr.add(5);arr.add(10);arr.add(25);
        int array[] = {1,5,10,25};
        assertEquals(arr,PA4.getChange(array,42));
    }
    @Test
    void getChangeWithArbitraryNumber() {   //one last test for good measure
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(1);arr.add(1);arr.add(1);arr.add(5);arr.add(25);
        arr.add(25);arr.add(25);arr.add(25);arr.add(25);arr.add(25);
        int array[] = {1,5,10,25};
        assertEquals(arr,PA4.getChange(array,159));
    }
}