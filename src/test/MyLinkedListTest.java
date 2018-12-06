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
    public void size() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void add1() {
    }

    @Test
    public void remove1() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void toArray() {
    }

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