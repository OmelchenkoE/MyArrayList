package test;

import main.SimpleListImpl;
import org.junit.Test;

import static org.junit.Assert.*;


public class SimpleListImplTest {
    SimpleListImpl target = new SimpleListImpl();
    Object o = new Object();

    @Test
    public void testGetAndSet() {
        target.add(o);
        target.set(0, o);
        assertEquals(o, target.get(0));
    }

    @Test
    public void testAddAndGet() {
        target.add(o);
        target.add(0, o);
        assertEquals(o, target.get(0));
    }

    @Test
    public void testRemove() {
        target.add(o);
        target.add("1");
        target.remove(0);
        target.remove("1");
        assertTrue(target.isEmpty());
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
}