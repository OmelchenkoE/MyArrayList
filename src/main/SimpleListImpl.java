package main;

import java.util.Arrays;
import java.util.Collection;

public class SimpleListImpl implements SimpleList {

    private final int MIN_ARRAY_SIZE = 16;
    private Object[] arr = new Object[MIN_ARRAY_SIZE];
    // TODO please rename to something more meaningful
    private int pointer = 0;

    @Override
    public Object get(int index) {
        // TODO This is wrong
        // Please write JUnits and find out where the bug is
        if (index < arr.length && index >= 0) {
            return arr[index];
        } else {
            // else clause is redundant here
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= pointer && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            // TODO else clause is rendundant here
            Object previousEl = arr[index];
            arr[index] = element;
            return previousEl;
        }
    }

    @Override
    public void add(int index, Object element) {
        // TODO this is wrong, 
        // hint: what is your list size?
        if (index > arr.length && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] temp = arr;
            if (pointer == arr.length) {
                arr = new Object[temp.length + MIN_ARRAY_SIZE];
            } else {
                System.arraycopy(temp, 0, arr, 0, index);
                System.arraycopy(temp, index, arr, index + 1, pointer);
                arr[index] = element;
            }
            pointer++;
        }
    }

    @Override
    public Object remove(int index) {
        if (index <= size() && index >= 0) {
            Object previousEl = arr[index];
            // TODO the implementation is wrong
            // for each remove call - If arr is not ready to be shrinked,
            // but you're still calling System.arraycopy(..) operation twice
            // you just need to copy elements AFTER the index in such case
            Object[] temp = arr;
            if (size() <= (arr.length - MIN_ARRAY_SIZE)) {
                arr = new Object[arr.length - MIN_ARRAY_SIZE];
            }
            System.arraycopy(temp, 0, arr, 0, index);
            int afterI = temp.length - index - 1;
            System.arraycopy(temp, index + 1, arr, index, afterI);
            pointer--;
            return previousEl;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return (pointer == 0);
        // TODO empty line - formatting
    }

    @Override
    public boolean add(Object o) {
        if (pointer == arr.length) {
            Object[] temp = arr;
            arr = new Object[temp.length + MIN_ARRAY_SIZE];
            System.arraycopy(temp, 0, arr, 0, temp.length);
        }
        arr[pointer] = o;
        pointer++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < pointer; i++) {
            if (o.equals(arr[i])) {
                // TODO the implementation is wrong
                // for each remove call - If arr is not ready to be shrinked,
                // but you're still calling System.arraycopy(..) operation twice
                // you just need to copy elements AFTER the removed element in such case
                Object[] temp = arr;
                if (size() <= (pointer - MIN_ARRAY_SIZE)) {
                    arr = new Object[arr.length - MIN_ARRAY_SIZE];
                }
                System.arraycopy(temp, 0, arr, 0, i);
                int afterI = temp.length - i - 1;
                System.arraycopy(temp, i + 1, arr, i, afterI);
                pointer--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        arr = new Object[MIN_ARRAY_SIZE];
        pointer = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < pointer; i++) {
            if (o.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(arr, 0, size());
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // TODO Iterate over c collection directly - don't call potentially expensive .toArray method
        int counter = 0;
        Object[] arrCol = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            if (contains(arrCol[i])) {
                counter++;
            }
        }
        return counter == c.size();
    }

    @Override
    public boolean addAll(Collection<?> c) {
        // TODO rename variable to smth meaningful
        boolean b = false;
        for (Object o : c) {
            if (add(o)) {
                b = true;
            }
        }
        return b;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        // TODO rename variable to smth meaningful        
        boolean b = false;
        for (Object o : c) {
            if (remove(o)) {
                b = true;
            }
        }
        return b;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO rename variable to smth meaningful
        boolean b = false;
        for (Object o : c) {
            if (!contains(o)) {
                remove(o);
                b = true;
            }
        }
        return b;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < pointer; i++) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO take a closer look on the condition in 'for' - please fix the border conditions
        for (int i = size(); i >= 0; i--) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
}
