package test;

import junit.framework.TestCase;
import main.MyLinkedList;
import org.junit.Test;

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
        for (int i = 0; i < mySize; i++) {
            target.add("" + i);
        }
        assertEquals(mySize, target.size());
        target.set(5, 5);
        assertEquals(5, target.get(5));
        target.set(0, 0);
        assertEquals(0, target.get(0));
        target.set(target.size() - 1, "TheLast");
        assertEquals("TheLast", target.get(target.size() - 1));
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
        assertEquals(mySize, target.size());
        assertEquals("" + 3, remove(3));
        assertEquals("" + 33, remove(32));
        assertEquals("" + 13, remove(12));
        assertEquals("" + 17, remove(15));
        assertEquals("" + 18, remove(15));
        assertEquals("" + 0, remove(0));
        assertEquals("" + 49, remove(43));
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
    public void testAddWithIndex() {
        String s = "new";
        String s12 = "new12";
        for (int i = 0; i < 10; i++) {
            target.add("old" + i);
        }
        assertEquals(10, target.size());
        target.add(0, s);
        assertEquals(s, target.get(0));
        assertEquals(11, target.size());
        target.add(5, "new5");
        assertEquals(12, target.size());
        target.add(12, s12);
        assertEquals(13, target.size());
        assertEquals(s12, target.get(12));
    }

    @Test
    public void testContains() {
        for (int i = 0; i < mySize; i++) {
            target.add("" + i);
        }
        assertFalse(target.contains("rtyui"));
        assertTrue(target.contains("3"));
    }

    @Test
    public void testToArray() {
        String s = "asd";
        for (int i = 0; i < mySize; i++) {
            target.add(s + i);
        }
        Object[] arr = target.toArray();
        for (int i = 0; i < target.size(); i++) {
            assertEquals(arr[i], target.get(i));
        }
    }

    //till here
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