package Sorting;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class QuickSort<T> implements SortAlgorithm<T> {

    private final ExecutorService executor;

    public QuickSort() {
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public QuickSort(int numOfThreads) {
        this.executor = Executors.newFixedThreadPool(numOfThreads);
    }

    @Override
    public void sort(List<T> list, Comparator<T> comporator) {
        try {
            new QuickSortTask(list, 0, list.size()-1, comporator).call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private class QuickSortTask implements Callable<Void> {
        private final List<T> list;
        private final int low;
        private final int high;
        private final Comparator<T> comparator;

        QuickSortTask(List<T> list, int low, int high, Comparator<T> comparator) {
            this.list = list;
            this.low = low;
            this.high = high;
            this.comparator = comparator;
        }

        @Override
        public Void call() throws Exception {
            if (low < high) {
                int pivotIndex = partition(list, low, high, comparator);

                new QuickSortTask(list, low, pivotIndex - 1, comparator).call();

                if (pivotIndex +1 < high) {
                    QuickSortTask rightTask = new QuickSortTask(list, pivotIndex + 1, high, comparator);
                    Future<Void> rightFuture = executor.submit(rightTask);
                    rightFuture.get();

                }
            }
            return null;
        }
    }

    private int partition(List<T> list, int low, int high, Comparator<T> comporator) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comporator.compare(list.get(j), pivot) <= 0) {
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

