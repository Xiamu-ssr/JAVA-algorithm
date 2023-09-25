package org.kmo.datastruct.SinglyLinkedList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class SinglyLinkedListTest {
    private Logger logger = LoggerFactory.getLogger("");
    @Test
    public void test(){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addLast(0);
        sll.addFirst(1);
        sll.addLast(2);
        for (Integer e:sll){
            System.out.printf("%d ",e);
        }System.out.println();
        logger.info("test01-add");
        assertIterableEquals(List.of(1,0,2),sll);
        logger.info("test02-get");
        assertEquals(2,sll.get(2));
        logger.info("test03-size");
        assertEquals(3,sll.size());
        logger.info("test04-insert");
        sll.insert(0,-1);
        sll.insert(1,100);
        sll.insert(sll.size()-1,888);
        sll.insert(sll.size(),999);
        assertIterableEquals(List.of(-1,100,1,0,888,2,999),sll);
        logger.info("test05-remove");
        sll.removeFirst();
        sll.remove(1);
        sll.remove(4);
        assertIterableEquals(List.of(100,0,888,2),sll);

    }
}
