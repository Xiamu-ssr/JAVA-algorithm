package org.kmo.datastruct.DynamicArray;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArrayTest {
    private Logger logger = LoggerFactory.getLogger("");
    @Test
    public void test(){
        DynamicArray da = new DynamicArray(new int[]{0,1,2,3,4,5,6,7,8,9,10});
        da.append(11);
        da.insert(11,1111);
        logger.info("断言测试01");
        assertIterableEquals(List.of(0,1,2,3,4,5,6,7,8,9,10,1111,11),da);
        Iterator<Integer> iterator = da.iterator();
        logger.info("调用iterator输出方式一");
        while (iterator.hasNext()){
            System.out.printf("%d ",iterator.next());
        }
        System.out.println();
        logger.info("调用iterator输出方式二");
        for (Integer e:da){
            System.out.printf("%d ",e);
        }
        System.out.println();
        logger.info("调用print输出");
        da.print();
        logger.info("调用forEach输出");
        da.forEach2(e->{
            System.out.printf("%d ",e);
        });
        System.out.println();
        logger.info("调用stream输出");
        da.stream().forEach(e->{
            System.out.printf("%d ",e);
        });
        System.out.println();
        logger.info("断言测试02");
        da.insert(9,new int[]{99,100,110,120,130,140});
        assertIterableEquals(List.of(0,1,2,3,4,5,6,7,8,99,100,110,120,130,140,9,10,1111,11),da);
        logger.info("断言测试03");
        da.pop();
        assertIterableEquals(List.of(0,1,2,3,4,5,6,7,8,99,100,110,120,130,140,9,10,1111),da);
        logger.info("断言测试04");
        da.remove(17);
        da.remove(15);
        da.remove(15);
        assertIterableEquals(List.of(0,1,2,3,4,5,6,7,8,99,100,110,120,130,140),da);
        logger.info("断言测试05");
        da.remove(0,5);
        assertIterableEquals(List.of(5,6,7,8,99,100,110,120,130,140),da);
        logger.info("断言测试06");
        da.set(0,5,1);
        assertIterableEquals(List.of(1,1,1,1,1,100,110,120,130,140),da);
        logger.info("断言测试07");
        assertEquals(10,da.size());
        assertEquals(16,da.capacity());
        logger.info("断言测试08");
        da.insert(10,new int[]{10,11,12,13,14,15,16});
        assertEquals(17,da.size());
        assertEquals(32,da.capacity());
        logger.info("断言测试09");
        da.pop();
        assertEquals(16,da.size());
        assertEquals(16,da.capacity());

    }
}
