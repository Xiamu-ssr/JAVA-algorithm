package org.kmo.datastruct.DynamicArray;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

public class DynamicArrayTest {
    private Logger logger = LoggerFactory.getLogger("");
    @Test
    public void test(){
        DynamicArray da = new DynamicArray(new int[]{0,1,2,3,4,5,6,7,8,9,10});
        da.append(11);
        da.insert(11,1111);
        Iterator<Integer> iterator = da.iterator();
        System.out.println();
        logger.info("调用iterator输出方式一");
        while (iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();
        logger.info("调用print输出");
        da.print();
        System.out.println();
        logger.info("调用forEach输出");
        da.forEach2(e->{
            System.out.print(e);
            System.out.print(" ");
        });
        da.insert(9,new int[]{99,100,110,120,130,140});
        System.out.println();
        logger.info("调用iterator输出方式二");
        for (Integer e:da){
            System.out.print(e);
            System.out.print(" ");
        }
        da.pop();
        da.remove(17);
        da.remove(15);
        da.remove(15);
        System.out.println();
        logger.info("调用stream输出");
        da.stream().forEach(e->{
            System.out.print(e);
            System.out.print(" ");
        });
    }
}
