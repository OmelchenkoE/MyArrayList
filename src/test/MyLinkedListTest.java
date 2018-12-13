package test;

import junit.framework.TestCase;
import main.MyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest extends TestCase {
    MyLinkedList target = new MyLinkedList();

    @Test
    public void testAddAndGet() {
        String s = "asd";
        target.add(s);
        target.add(s+1);
        assertEquals(s, target.get(0));
        assertEquals(s+1, target.get(1));
    }

    @Test
    public void testSet() {
    }


    @Test
    public void testRemove() {
    }

    @Test
    public void testSize() {
        assertEquals(0,target.size());
        target.add("q");
        assertEquals(1,target.size());
        target.add("w");
        assertEquals(2,target.size());
    }

    @Test
    public void testClearAndIsEmpty() {
        target.clear();
        assertTrue(target.isEmpty());
        target.add("asd");
        assertFalse(target.isEmpty());
    }

    @Test
    public void testAdd() {
    }

    @Test
    public void testContains() {
    }

    @Test
    public void testToArray() {
    }
/////////////////
    @Test
    public void containsAll() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void removeAll() {
    }

    @Test
    public void retainAll() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void lastIndexOf() {
    }
}