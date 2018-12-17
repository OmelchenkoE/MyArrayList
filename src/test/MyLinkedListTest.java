package test;

import junit.framework.TestCase;
import main.MyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest extends TestCase {
    MyLinkedList target = new MyLinkedList();
    int mySize = 50;

    @Test
    public void testAddAndGet() {
        String s = "asd";
        target.add(s);
        target.add(s + 1);
        assertEquals(s, target.get(0));
        assertEquals(s + 1, target.get(1));
    }

    @Test
    public void testSet() {
    }

    private Object remove(int index) {
        mySize--;
        return target.remove(index);
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < mySize; i++) {
            target.add("" + i);
        }
        for (int i = 0; i < target.size(); i++) {
            System.out.println(target.get(i));
        }
        System.out.println();
        assertEquals(mySize, target.size());
        assertEquals("" + 3, remove(3));
        assertEquals("" + 33, remove(32));
        assertEquals("" + 13, remove(12));
        assertEquals("" + 17, remove(15));
        assertEquals("" + 18, remove(15));
        assertEquals("" +0,remove(0));
        assertEquals("" +49,remove(43));
        for (int i = 0; i < target.size(); i++) {
            System.out.println(target.get(i));
        }
        assertEquals(mySize, target.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, target.size());
        target.add("q");
        assertEquals(1, target.size());
        target.add("w");
        assertEquals(2, target.size());
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