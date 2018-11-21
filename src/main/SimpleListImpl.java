package main;

import java.util.Collection;

public class SimpleListImpl implements SimpleList {
    private final int MIN_ARRAY_SIZE = 16;    
    private Object[] arr = new Object[MIN_ARRAY_SIZE];
    // TODO
    // General comment about the pointer:
    // Seems that you don't fully understand what is contained
    // in your array at the 'pointer' position
    private int pointer = 0;

    @Override
    public Object get(int index) {
        // TODO do you need an "else" clause here?
        if (index < arr.length && index >= 0) {
            return arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        // TODO: do you need an else clause here?
        if (index >= pointer && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Object previousEl = arr[index];
            arr[index] = element;
            return previousEl;
        }
    }

    @Override
    public void add(int index, Object element) {
        // TODO: do you need an else clause here?
        if (index > arr.length && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] temp = arr;
            if (pointer == arr.length - 1) {
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
        // TODO: do you need an else clause here?
        if (index <= size() && index >= 0) {
            Object previousEl = arr[index];
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

    }

    @Override
    public boolean add(Object o) {
        // TODO: this is incorrect - you still have 1 free space in array - but you're already resizing an array
        if (pointer == arr.length - 1) {
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
                Object[] temp = arr;
                // TODO: the following line is incorrect - your array will shrink every time you remove an element
                // which makes the whole remove operation incorrect
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
        // Why didn't you use a simpler one-line function Arrays.copyOfRange(Object[] src, int from, int to)
        Object[]rArr = new Object[size()] ;
        System.arraycopy(arr, 0, rArr, 0, size());
        return rArr;
    }

    // TODO In general, method will work, but:
    // 1) Why do you call c.toArray() - it's a Collection, you can iterate over it directly
    // 2) It is not efficient -  whenever any of elements from 'c' is not found - you can return 'false' immediately,
    // no need to continue checks
    @Override
    public boolean containsAll(Collection<?> c) {
        int counter = 0;
        Object[] arrCol = c.toArray();
        for (int i = 0; i < c.size(); i++) {
            if (contains(arrCol[i])) {
                counter++;
            }
        }
        return counter == c.size();
    }

    // TODO - why do you count anything?
    // You just need to add elements and return 'true'
    // Your collection will ALWAYS change if you add elements
    @Override
    public boolean addAll(Collection<?> c) {
        int counter = 0;
        for (Object o : c) {
            if (add(o)) {
                counter++;
            }
        }
        return counter > 0;
    }

    //TODO - you need a simple boolean flag for this method
    //No need to count
    @Override
    public boolean removeAll(Collection<?> c) {
        int counter = 0;
        for (Object o : c) {
            if (remove(o)) {
                counter++;
            }
        }
        return counter > 0;
    }

    // TODO same here - you just need a boolean, no need to count
    @Override
    public boolean retainAll(Collection<?> c) {
        int counter = 0;
        for (Object o : c) {
            if (!contains(o)) {
                remove(o);
                counter++;
            }
        }
        return counter > 0;
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
    // TODO: condition for the loop is incorrect (although it will probably run fine most of the time)
    // Please check border conditions
    public int lastIndexOf(Object o) {
        for (int i = size(); i >= 0; i--) {
            if (o.equals(arr[i])) {
                return i;
            }
        }
        return -1;
    }
}
