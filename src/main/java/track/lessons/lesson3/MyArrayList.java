package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Должен наследовать List
 *
 * Должен иметь 2 конструктора
 * - без аргументов - создает внутренний массив дефолтного размера на ваш выбор
 * - с аргументом - начальный размер массива
 */
public class MyArrayList extends List {

    public MyArrayList() {
        length = 0;
        currentCapacity = initialCapacity;
        array = new int[initialCapacity];
    }

    public MyArrayList(int capacity) {
        length = 0;
        currentCapacity = capacity;
        if (capacity == 0) {
            ++currentCapacity;
        }
        array = new int[currentCapacity];
    }

    @Override
    void add(int item) {
        if (length == currentCapacity ) {
            currentCapacity *= 2;
            int[] newArray = new int[currentCapacity];
            System.arraycopy(array, 0, newArray, 0, length);
            newArray[length] = item;
            ++length;
            array = newArray;
        } else {
            array[length] = item;
            ++length;
        }
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        int element;
        if (idx < length) {
            int[] newArray = new int [currentCapacity];
            System.arraycopy(array, 0, newArray, 0, idx);
            System.arraycopy(array, idx + 1, newArray, idx, length - idx - 1);
            --length;
            element = array[idx];
            array = newArray;
        } else {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    int get(int idx) throws NoSuchElementException {
        int element;
        if (idx < length) {
            element = array[idx];
        } else {
            throw new NoSuchElementException();
        }
        return element;
    }

    @Override
    int size() {
        return length;
    }

    private int[] array;
    private int initialCapacity = 32;
    private int currentCapacity;
    private int length;
}

