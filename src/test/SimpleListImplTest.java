package test;

import main.SimpleListImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleListImplTest {

    SimpleListImpl target = new SimpleListImpl();
    Object o = new Object();

    @Test
    public void testSet() {
        target.add(o);
        target.set(0, 1);
        assertEquals(1, target.get(0));
    }

    @Test
    public void testAddAndGet() {
        for (int i = 0; i < 16; i++) {
            target.add(i);
        }
        target.add(o);
        assertEquals(o, target.get(16));
    }

    @Test
    public void testAddAndGetWithIndex() {
        for (int i = 0; i < 88; i++) {
            target.add(i, "b" + i);
        }
        assertEquals("b55", target.get(55));
    }

    @Test
    public void testRemove() {
        target.add(o);
        target.add("1");
        target.remove(0);
        target.remove("1");
        assertTrue(target.isEmpty());
        for (int i = 0; i < 8; i++) {
            target.add(o);
            target.add("1");
        }
        target.add("last");
        assertEquals(17,target.size());
        target.remove("1");
        target.remove(0);
        assertEquals(15,target.size());
    }

    @Test
    public void testSize() {
        assertEquals(0, target.size());
    }

    @Test
    public void testIsEmptyTrue() {
        assertTrue(target.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        target.add(o);
        assertFalse(target.isEmpty());
    }

    @Test
    public void testClear() {
        target.add(o);
        target.clear();
        assertFalse(target.contains(o));
    }

    @Test
    public void testContains() {
        target.add(o);
        assertTrue(target.contains(o));
    }

    @Test
    public void testToArray() {
        target.add(o);
        assertEquals(o, target.toArray()[0]);
    }

    @Test
    public void testContainsAll() {
        target.add(o);
        ArrayList list = new ArrayList();
        list.add(o);
        assertTrue(target.containsAll(list));
    }

    @Test
    public void testAddAll() {
        ArrayList list = new ArrayList();
        list.add(o);
        assertTrue(target.addAll(list));
    }

    @Test
    public void testRemoveAll() {
        target.add(o);
        ArrayList list = new ArrayList();
        list.add(o);
        assertTrue(target.removeAll(list));
    }

    @Test
    public void testRetainAll() {
        int p = 564;
        int g = 400;
        for (int i = 0; i < p; i++) {
            target.add(i);
        }
        target.add(o);
        assertEquals(p+1, target.size());
        ArrayList list = new ArrayList();
        for (int i = 0; i < g; i++) {
            list.add(i);
        }
        list.add(o);
        assertTrue(target.retainAll(list));
        assertEquals(g+1, target.size());
        target.clear();
        for (int i = 1; i < 5; i++) {
            target.add(i);
        }
        ArrayList list1 = new ArrayList();
        for (int i = 4; i > 0; i--) {
            list1.add(i);
        }
        assertFalse(target.retainAll(list1));
        for (int i = 0; i < 4; i++) {
            assertFalse(target.get(i) == list1.get(i));
        }
    }

    @Test
    public void testIndexOf() {
        target.add(o);
        assertEquals(0, target.indexOf(o));
    }

    @Test
    public void testLastIndexOf() {
        target.add(o);
        assertEquals(0, target.lastIndexOf(o));
    }
}
