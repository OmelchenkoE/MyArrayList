package main;

public class SimpleListImpl implements SimpleList {
    private Object[] arr = new Object[0];

    @Override
    public Object get(int index) {
        if (index < arr.length) {
            return arr[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Object set(int index, Object element) {
        if (index >= arr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            arr[index] = element;
            return arr[index];
        }
    }

    @Override
    public void add(int index, Object element) {
        if (index >arr.length) {
            throw new IndexOutOfBoundsException();
        } else {
            Object[] temp = arr;
            arr = new Object[temp.length + 1];
            System.arraycopy(temp, 0, arr, 0, index);
            arr[index] = element;
            System.arraycopy(temp, index, arr, index + 1, temp.length-index);
        }
    }

    @Override
    public Object remove(int index) {
        if (index < size()) {
            Object[] temp = arr;
            arr = new Object[arr.length - 1];
            System.arraycopy(temp, 0, arr, 0, index);
            int aftterI = temp.length - index - 1;
            System.arraycopy(temp, index + 1, arr, index, aftterI);
            return true;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(Object o) {
        Object[] temp = arr;
        arr = new Object[temp.length + 1];
        System.arraycopy(temp, 0, arr, 0, temp.length);
        arr[arr.length - 1] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int j = 0;
        for (int i = 0; i < size(); i++) {
            if (o == arr[i]) {
                Object[] temp = arr;
                arr = new Object[arr.length - 1];
                System.arraycopy(temp, 0, arr, 0, i);
                int aftterI = temp.length - i - 1;
                System.arraycopy(temp, i + 1, arr, i, aftterI);
                j++;
            }
        }
        if (j > 0) {
            return true;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void clear() {
        if (arr.length == 0) {
            throw new UnsupportedOperationException();
        } else {
            arr = new Object[0];
        }
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size(); i++) {
            if (arr[i] == o) {
                return true;
            } else {
            }
        }
        return false;
    }
}