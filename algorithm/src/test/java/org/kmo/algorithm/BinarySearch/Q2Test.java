package org.kmo.algorithm.BinarySearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class Q2Test {
    public ArrayList<Integer> trans(Integer[] arr){
        return new ArrayList<Integer>(Arrays.asList(arr));
    }

    @Test
    public void test(){
        assertEquals(4, new Q2(trans(new Integer[]{1,2,3,3,3,3,4,5})).find(3));
        assertEquals(0, new Q2(trans(new Integer[]{1,3,4,5})).find(6));
    }
}
