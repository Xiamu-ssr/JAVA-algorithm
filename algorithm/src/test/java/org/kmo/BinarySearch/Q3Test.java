package org.kmo.BinarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q3Test {

    @Test
    public void test(){
        assertEquals(2, new Q3().find(8));
        assertEquals(2, new Q3().find(4));
        assertEquals(3, new Q3().find(15));
        assertEquals(8, new Q3().find(80));
    }
}
