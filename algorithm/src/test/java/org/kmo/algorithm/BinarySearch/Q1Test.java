package org.kmo.algorithm.BinarySearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q1Test {
    public ArrayList<Integer> trans(Integer[] arr){
        return new ArrayList<Integer>(Arrays.asList(arr));
    }
    @Test
    public void test(){
        assertEquals(1,new Q1(trans(new Integer[]{3,1,2})).find());
        assertEquals(1,new Q1(trans(new Integer[]{3,4,5,1,2})).find());
        assertEquals(3,new Q1(trans(new Integer[]{3,100,200,3})).find());
        assertEquals(3,new Q1(trans(new Integer[]{3,4,4,4,4,4})).find());
    }
}
