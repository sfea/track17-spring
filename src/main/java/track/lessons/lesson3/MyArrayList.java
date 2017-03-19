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

    private int[] array;

    private int pointer = 0;

    public static final int DEFAULT_CAPACITY = 16;

    public MyArrayList() {
        array = new int[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        array = new int[capacity];
    }

    public void resize(int[] array, int newlength) {
        int[] newArray = new int[newlength];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    void add(int item) {
        if (pointer >= array.length - 1) {
            resize(array, (array.length + 1) * 2);
        }
        array[pointer] = item;
        pointer++;
    }

    @Override
    int remove(int idx) throws NoSuchElementException {
        if (idx < 0 || idx >= pointer) {
            throw new NoSuchElementException();
        }
        System.arraycopy(array, idx + 1, array, idx, pointer - idx);
        pointer--;
        return 0;
    }

    @Override
    int get(int idx) throws NoSuchElementException {
        if (idx < 0 || idx >= pointer) {
            throw new NoSuchElementException();
        }
        return array[idx];
    }

    @Override
    int size() {
        return pointer;
    }
}
