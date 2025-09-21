package Sorting;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class QuickSort<T> implements SortAlgorithm<T> {

    private final ExecutorService executor;
    private static final int THRESHOLD = 1000;
    private static final int MAX_DEPTH = 20;

    public QuickSort() {
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public QuickSort(int numOfThreads) {
        this.executor = Executors.newFixedThreadPool(numOfThreads);
    }

    @Override
    public void sort(List<T> list, Comparator<T> comparator) {
        try {
            executor.submit(new QuickSortTask(list, 0, list.size()-1, comparator, 0)).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private class QuickSortTask implements Callable<Void> {
        private final List<T> list;
        private final int low, high, depth;
        private final Comparator<T> comparator;

        QuickSortTask(List<T> list, int low, int high, Comparator<T> comparator, int depth) {
            this.list = list;
            this.low = low;
            this.high = high;
            this.comparator = comparator;
            this.depth = depth;
        }

        @Override
        public Void call() throws Exception {
            if (low < high) {
                if (depth >= MAX_DEPTH || high - low < THRESHOLD) {
                    sequentialQuickSort(list, low, high, comparator);
                    return null;
                }

                int pivotIndex = partition(list, low, high, comparator);

                if (pivotIndex - low > high - pivotIndex) {
                    sequentialQuickSort(list, low, pivotIndex - 1, comparator);
                    executor.submit(new QuickSortTask(list, pivotIndex + 1, high, comparator, depth+1)).get();
                } else {
                    executor.submit(new QuickSortTask(list, low, pivotIndex - 1, comparator, depth+1)).get();
                    sequentialQuickSort(list, pivotIndex + 1, high, comparator);
                }

            }
            return null;
        }
    }
    private void sequentialQuickSort(List<T> list, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, comparator);
            sequentialQuickSort(list, low, pivotIndex - 1, comparator);
            sequentialQuickSort(list, pivotIndex + 1, high, comparator);
        }
    }

    private int partition(List<T> list, int low, int high, Comparator<T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;

                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        T temp = list.get(i+1);
        list.set(i+1, list.get(high));
        list.set(high, temp);

        return i+1;
    }
}

