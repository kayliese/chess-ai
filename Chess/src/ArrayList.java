import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class ArrayList<T> implements List<T> {
    private int size;
    private Object[] list;
    private int capacity;
    public static final int DEFAULT_CAPACITY = 32;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        list = new Object[initialCapacity];
        capacity = initialCapacity;
        size = 0;
    }

    public boolean add(int index, T obj) {
        if (index < 0 || index > size) {
            return false;
        }
        if (size == capacity) {
            resizeArray(2 * capacity);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i -1];
        }
        list[index] = obj;
        size++;
        return true;
    }

    public boolean add(T obj) {
        if (size == capacity) {
            resizeArray(2 * capacity);
        }
        list[size++] = obj;
        return true;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if  (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T)list[index];
    }

    public int indexOf(T obj) {
        int index = 0;
        boolean found = false;
        while (index < size && !found) {
            if (list[index] == obj || (list[index] != null && list[index].equals(obj))) {
                found = true;
            } else {
                index++;
            }
        }
        return found?index:-1;

    }

    public int lastIndexOf(T obj) {
        int index = size - 1;
        boolean found = false;
        while (index >= 0 && !found) {
            if (list[index] == obj || (list[index] != null && list[index].equals(obj))) {
                found = true;
            } else {
                index--;
            }
        }
        return found?index:-1;
    }
    
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            static final int PREVIOUS = 1;
            static final int NEXT = 2;
            int lastCalled = 0;
            //LastCalled indicates if next or previous have been called.
            int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException("End of collection");
                lastCalled = NEXT;
                return (T)(list[nextIndex++]);
            }

            @Override
            public boolean hasPrevious() {
                return nextIndex > 0;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T previous() {
                if (!hasPrevious())
                    throw new NoSuchElementException("Start of collection");
                lastCalled = PREVIOUS;
                return (T)list[--nextIndex];
            }

            @Override
            public int nextIndex() {
                return nextIndex;
            }

            @Override
            public int previousIndex() {
                return nextIndex-1;
            }

            @Override
            public void remove() {
                if(lastCalled == PREVIOUS) { //Remove current postiion
                    ArrayList.this.remove(nextIndex);
                } else if (lastCalled == NEXT) { //Remove last position
                    ArrayList.this.remove(--nextIndex);
                } else {
                    throw new IllegalStateException("removed called without next or previous");
                }
                lastCalled = 0; //Reset last called to prevent repeated calls.
            }

            @Override
            public void set(T e) {
                if (lastCalled == PREVIOUS) {
                    list[nextIndex] = e;
                } else if (lastCalled == NEXT) {
                    list[nextIndex-1] = e;
                } else {
                    throw new IllegalStateException("set called without next or previous");
                }

            }

            @Override
            public void add(T e) {
                ArrayList.this.add(nextIndex++, e);
            }

        };
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T obj = get(index);
        for (int i = index; i < size-1; i++) {
            list[i] = list[i+1];
        }
        list[--size] = null;
        return obj;
    }

    public T set(int index, T obj) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T old = get(index);
        list[index] = obj;
        return old;
    }

    public boolean contains(T obj) {
        return indexOf(obj) >= 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        list = new Object[capacity];
        size = 0;
        
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(list, size);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a) {
        return (T[])Arrays.copyOf(list, size, a.getClass());
    }

    private void resizeArray(int newCapacity) {
        list = Arrays.copyOf(list, newCapacity);
        capacity = newCapacity;
    }
}
