import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;

public class Average{

    public static int average(int k, int[] list){
        int average = 0;
        int n = Math.min(k, list.length);
        if( n > 0) {
            for(int i = 0 ; i < n; i++){
                average += list[i];
            }
            average = average/n;
        }
        return average;
    }

    @Test
    public void kBoundaryTest() {
        int[] list = {-11, 34, 26, -26, 50, 4, -11, 47, -11, 38};
        assertEquals(average(-1,list), 0);
        assertEquals(average(0,list), 0);
        assertEquals(average(1,list), -11);

        assertEquals(average(9,list), 11);
        assertEquals(average(10,list), 14);
        assertEquals(average(11,list), 14);

        assertEquals(average(Integer.MAX_VALUE,list), 14);
        assertEquals(average(Integer.MIN_VALUE,list), 0);
    }

    @Test
    public void emptyListTest() {
        int[] list = {};
        assertEquals(average(0,list), 0);
        assertEquals(average(-5,list), 0);
        assertEquals(average(5,list), 0);
    }

    @Test
    public void listBoundaryTest() {
        int[] list = {1};
        assertEquals(average(5,list), 1);
        int[] list2 = {1,3};
        assertEquals(average(5,list2), 2);
        int[] list3 = new int[1000000];
        //Arrays.fill(list3, 0);
        assertEquals(average(5,list3), 0);
        int[] list4 = new int[1000000-1];
        //Arrays.fill(list4, 0);
        assertEquals(average(5,list4), 0);
        int[] list5 = new int[1000000+1];
        //Arrays.fill(list5, 0);
        assertEquals(average(5,list5), 0);
    }

    @Test
    public void partitionTest() {
        int[] list = {-11, 34, 26, -26, 50, 4, -11, 47, -11, 38};
        assertEquals(average(-5,list), 0);
        assertEquals(average(5,list), 14);
        assertEquals(average(15,list), 14);
    }    
}
    