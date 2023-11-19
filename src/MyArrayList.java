import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T> {
    private static final int DefaultLength = 1;
    private T[] array;
    private int length;
    private int maxLengthArray;

    public MyArrayList() {
        array = (T[]) new Object[DefaultLength];
        length = 0;
        maxLengthArray = DefaultLength;
    }

    public boolean add(T element) {
        length++;
        if (length == maxLengthArray) {
            expansionArray();
        }
        array[length - 1] = element;
        return true;
    }

    public boolean add(int i, T element) {
        length++;
        if (length == maxLengthArray) {
            expansionArray();
        }
        if (array[i] != null) {
            offsetArray(i, element);
        } else {
            if (array[i - 1] == null) {
                throw new IndexOutOfBoundsException();
            } else {
                array[i] = element;
            }
        }
        return true;
    }

    public boolean addAll(MyArrayList<T> c) {
        length += c.length;
        if (length >= maxLengthArray) {
            expansionArray(c.length);
        }
        for (int i = length - c.length, j = 0; i < length; i++, j++) {
            this.array[i] = c.get(j);
        }
        return true;
    }

    public T get(int index) {
        return array[index];
    }

    public boolean isEmpty() {
        return length == 0;
    }

    private void offsetArray(int i, T element) {
        for (int j = length; j > i; j--) {
            array[j] = array[j - 1];
        }
        array[i] = element;
    }

    private void expansionArray() { //расширение массива
        int v = (int) (maxLengthArray + 1);
        T[] tempArray = (T[]) new Object[v];
        for (int i = 0; i < maxLengthArray; i++) {
            tempArray[i] = array[i];
        }
        maxLengthArray = v;
        array = tempArray;
    }

    public int size() {
        return length;
    }

    private void expansionArray(int size) { //расширение массива
        int v = ((maxLengthArray + size) + 1);
        T[] tempArray = (T[]) new Object[v];
        for (int i = 0; i < maxLengthArray; i++) {
            tempArray[i] = array[i];
        }
        maxLengthArray = v;
        array = tempArray;
    }

    public boolean clear() {
        for (int i = 0; i < length; i++) {
            array[i] = null;
        }
        return false;
    }

    public void remove(int index) {
        for (int i = index; i < length; i++) {
            array[i] = array[i + 1];
        }
    }

    public void remove(Object o) {
        for (int i = 0; i < length; i++) {
            if (o.equals(array[i])) {
                remove(i);
            }
        }
    }
    public void showToString() {
        System.out.println(Arrays.toString(Arrays.stream(array).filter(Objects::nonNull).toArray()));
    }
    public void sort(Comparator<? super T> c) {
        mergeSort(0, length - 1, c);
    }
    private void mergeSort(int lower, int higher, Comparator<? super T> c) {
        if (lower < higher) {
            int middle = lower + (higher - lower) / 2;
            mergeSort(lower, middle, c);
            mergeSort(middle + 1, higher, c);
            merge(lower, middle, higher, c);
        }
    }
    private void merge(int lower, int middle, int higher, Comparator<? super T> c) {
        T[] temp = Arrays.copyOf(array, length);   // копия  массива
        int left = lower;
        int right = middle + 1;
        int current = lower;
        while (left <= middle && right <= higher) {
            if (temp[left] == null) {
                array[current++] = temp[right++];
            } else if (temp[right] == null || c.compare(temp[left], temp[right]) <= 0) {
                array[current++] = temp[left++];
            } else {
                array[current++] = temp[right++];
            }
        }
        while (left <= middle) {
            array[current++] = temp[left++];
        }
    }
}
