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
        // You're right, the docs say that:
        // IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
        if (index > listSize || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] temp = arr;
        if (listSize == arr.length) {
            arr = new Object[temp.length + MIN_ARRAY_SIZE];
            System.arraycopy(temp, 0, arr, 0, index);
        }
        // TODO: There is a bug in parameters of System.arraycopy(..) method.
        // Please carefully read it's documentation
        // Please run tests with following logic:
        // Perform list.add(..); 10 times with indexes 0..9
        // Then try doing list.add(9, 'a')
        System.arraycopy(temp, index, arr, index + 1, listSize);
        arr[index] = element;
        listSize++;
    }

    @Override
    public Object remove(int index) {
        // TODO: Style: please decide if you use size() or listSize and stick to one variant in all methods
        if (index < size() && index >= 0) {
            Object previousEl = arr[index];
            Object[] temp = arr;
            if (size() <= (arr.length - MIN_ARRAY_SIZE)) {
                arr = new Object[arr.length - MIN_ARRAY_SIZE];
                System.arraycopy(temp, 0, arr, 0, index);
            }
            int afterI = temp.length - index - 1;
            System.arraycopy(temp, index + 1, arr, index, afterI);
            listSize--;
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
        if (listSize == arr.length) {
            Object[] temp = arr;
            arr = new Object[temp.length + MIN_ARRAY_SIZE];
            System.arraycopy(temp, 0, arr, 0, temp.length);
        }
        arr[listSize] = o;
        listSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (o.equals(arr[i])) {
                Object[] temp = arr;
                if (size() <= (arr.length - MIN_ARRAY_SIZE)) {
                    arr = new Object[arr.length - MIN_ARRAY_SIZE];
                    System.arraycopy(temp, 0, arr, 0, i);
                }
                int afterI = temp.length - i - 1;
                System.arraycopy(temp, i + 1, arr, i, afterI);
                listSize--;
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
        for (int i = 0; i < listSize; i++) {
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
    // TODO: There is a serious bug in this method
    // Consider case when:
    // myArrayList = [1,2,3,4]
    // c = [4,3,2,1]
    // This method should basically leave myArrayList intact
    // Please create JUnits and see what happens
    // Implementation idea is kind of OK
    public boolean retainAll(Collection<?> c) {
        int j = 0;
        boolean wasChanged = false;
        Object[] temp = new Object[arr.length];
        for (Object o:c) {
            if (contains(o)) {
                temp[j++] = o;
                wasChanged = true;
            }
        }
        listSize = j;
        if (size() < arr.length - MIN_ARRAY_SIZE) {
            arr = new Object[(size() / MIN_ARRAY_SIZE + 1) * MIN_ARRAY_SIZE];
            System.arraycopy(temp, 0, arr, 0, size());
        } else {
            arr = temp;
        }
        return wasChanged;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < listSize; i++) {
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
}
