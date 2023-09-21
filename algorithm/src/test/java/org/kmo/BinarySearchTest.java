package org.kmo;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void Test(){
        int[] arr = {1, 3, 4, 5, 7, 10, 11, 14, 16, 18};
        assertEquals(1, new BinarySearch().main(arr, 3));
        assertEquals(0, new BinarySearch().main(arr, 1));
        assertEquals(-1, new BinarySearch().main(arr, -1));
        assertEquals(4, new BinarySearch().main(arr, 7));
        assertEquals(9, new BinarySearch().main(arr, 18));
    }

}
