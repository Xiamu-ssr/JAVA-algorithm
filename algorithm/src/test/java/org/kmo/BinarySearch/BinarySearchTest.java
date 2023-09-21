package org.kmo.BinarySearch;

import org.junit.Test;
import org.kmo.BinarySearch.BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void Test(){
        Integer[] testArr = {1, 3, 4, 5, 7, 10, 11, 14, 16, 18};
        // 使用花括号{}包围初始值，然后使用Arrays类的asList方法和ArrayList的构造函数，创建一个ArrayList
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(testArr));

        BinarySearch bsc = new BinarySearch(arr);
        assertEquals(1, bsc.find(3));
        assertEquals(0, bsc.find(1));
        assertEquals(-1, bsc.find(-1));
        assertEquals(4, bsc.find(7));
        assertEquals(9, bsc.find(18));
        assertEquals(2, bsc.find(4));
    }

}
