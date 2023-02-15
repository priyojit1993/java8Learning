package javaConcurrency.fork_join_framework_demo.merge_sort_fork_join;

import java.util.concurrent.RecursiveAction;

public class MergeSortRecursiveAction extends RecursiveAction {

    int arr[];


    public MergeSortRecursiveAction(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected void compute() {
        if (arr.length < 2)
            return;
        else {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            System.arraycopy(arr, 0, left, 0, mid);
            int[] right = new int[arr.length - mid];
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            invokeAll(new MergeSortRecursiveAction(left), new MergeSortRecursiveAction(right));

            merge(left, right);

        }
    }

    private void merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{5,4,3,2,1};
        new MergeSortRecursiveAction(x).invoke();
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i]);
        }
    }
}
