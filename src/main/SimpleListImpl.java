package main;

public class SimpleListImpl implements SimpleList {
    private final int MIN_ARRAY_SIZE = 16;
    private Object[] arr = new Object[MIN_ARRAY_SIZE];
    private int pointer = 0;

    @Override
    public Object get(int index) {
        if (index < arr.length && index >= 0) {
            return arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= arr.length && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Object previousEl = arr[index];
            arr[index] = element;
            return previousEl;
        }
    }

    @Override
    public void add(int index, Object element) {
        if (index > arr.length && index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (pointer == arr.length - 1) {
                Object[] temp = arr;
                arr = new Object[temp.length + MIN_ARRAY_SIZE];
                System.arraycopy(temp, 0, arr, 0, index);
                arr[index] = element;
                System.arraycopy(temp, index, arr, index + 1, temp.length - index);
            } else {
                arr[index] = element;
            }
            pointer++;
        }
    }

    @Override
    public Object remove(int index) {
        if (index < size() && index >= 0) {
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
        for (int i = 0; i < size(); i++) {
            if (o.equals(arr[i])) {
                Object[] temp = arr;
                if (size() <= (arr.length - MIN_ARRAY_SIZE)) {
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
        pointer=0;
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
}