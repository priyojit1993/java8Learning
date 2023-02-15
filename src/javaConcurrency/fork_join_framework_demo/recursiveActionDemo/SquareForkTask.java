package javaConcurrency.fork_join_framework_demo.recursiveActionDemo;

import java.util.concurrent.RecursiveAction;

public class SquareForkTask extends RecursiveAction {

    double arr[];
    int start;
    int end;

    int threshold = 1;

    public SquareForkTask(double[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) <= threshold) {
            for (int i = start; i < end; i++) {
                arr[i] = Math.sqrt(arr[i]);
            }
        } else {
            int mid = (end +start) / 2;
            invokeAll(new SquareForkTask(arr, start, mid), new SquareForkTask(arr, mid, end));
        }
    }
}
