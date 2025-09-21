package Sorting;

import Entity.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuickSortEven<T> implements SortAlgorithm<T> {

    private final QuickSort<T> quickSort;

    public QuickSortEven() {
        this.quickSort = new QuickSort<>();
    }

    public QuickSortEven(int numOfThreads) {
        this.quickSort = new QuickSort<>(numOfThreads);
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        List<T> evenElements = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            if (isEven(element)) {
                evenElements.add(element);
                indexes.add(i);
            }
        }

        quickSort.sort(evenElements, comparator);

        for (int i = 0; i < indexes.size(); i++) {
            list.set(indexes.get(i), evenElements.get(i));
        }
    }

    private boolean isEven(T elem) {
        if (elem instanceof Person p) {
            return p.getBirthYear() % 2 == 0;
        }
        return false;
    }
}
