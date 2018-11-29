package main;

import java.util.Arrays;
import java.util.Collection;

public class SimpleListImpl implements SimpleList {

    private final int MIN_ARRAY_SIZE = 16;
    private Object[] arr = new Object[MIN_ARRAY_SIZE];
    private int listSize = 0;

    @Override
    public Object get(int index) {
        if (index < listSize && index >= 0) {
            return arr[index];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object previousEl = arr[index];
        arr[index] = element;
        return previousEl;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] temp = arr;
        ensureCapacity();
        System.arraycopy(temp, index, arr, index + 1, size() - index);
        arr[index] = element;
        listSize++;
    }

    @Override
    public Object remove(int index) {
        if (index < size() && index >= 0) {
            Object previousEl = arr[index];
            Object[] temp = arr;
            listSize--;
            ensureCapacity();
            int afterI = arr.length - index - 1;
            System.arraycopy(temp, index + 1, arr, index, afterI-1);
            // TODO: bug here - what if ensureCapacity shrinks your array?
            return previousEl;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public boolean add(Object o) {
        ensureCapacity();
        arr[size()] = o;
        listSize++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size(); i++) {
            if (o.equals(arr[i])) {
                Object[] temp = arr;
                listSize--;
                ensureCapacity();
                int afterI = arr.length - i - 1;
                System.arraycopy(temp, i + 1, arr, i, afterI);
                // TODO there is a bug here - what if ensureCapacity shrinks your array?
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        arr = new Object[MIN_ARRAY_SIZE];
        listSize = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
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
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<?> c) {
        boolean wasChanged = false;
        for (Object o : c) {
            if (add(o)) {
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean wasChanged = false;
        for (Object o : c) {
            if (remove(o)) {
                wasChanged = true;
            }
        }
        return wasChanged;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int j = 0;
        boolean wasChanged = false;
        Object[] temp = new Object[arr.length];
        for (int i = 0; i < size(); i++) {
            if (c.contains(arr[i])) {
                temp[j++] = arr[i];
            }
        }
        if (j != size()) {
            wasChanged = true;
        }
        listSize = j;
        ensureCapacity();
        return wasChanged;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }

    // TODO: you're calling this method always with size() as a parameter - please remove this parameter
    // Please include also code that copies elements into new array after resize
    private boolean ensureCapacity() {
        Object[] anotherTemp = arr;
        if (size() == arr.length) {
            arr = new Object[arr.length + MIN_ARRAY_SIZE];
            System.arraycopy(anotherTemp, 0, arr, 0, anotherTemp.length);
            return true;
        }
        if (size() < arr.length - MIN_ARRAY_SIZE) {
            System.arraycopy(anotherTemp, 0, arr, 0, anotherTemp.length);
            arr = new Object[(size() / MIN_ARRAY_SIZE + 1) * MIN_ARRAY_SIZE];
            return true;
        }
        return false;
    }
}
