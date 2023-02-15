package javaConcurrency.fork_join_framework_demo.recursiveTaskDemo;

import java.util.concurrent.RecursiveTask;

public class ArraySumRecursiveTask extends RecursiveTask<Integer> {

    private int[] arr;
    private int beg;
    private int end;

    private int threshold = 10;

    public ArraySumRecursiveTask(int[] arr, int beg, int end) {
        this.arr = arr;
        this.beg = beg;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        if ((end - beg) < threshold) {
            for (int i = beg; i < end; i++) {
                sum += arr[i];
            }
        } else {
            int mid = (beg + end) / 2;
            ArraySumRecursiveTask subtask1 = new ArraySumRecursiveTask(arr, beg, mid);
            ArraySumRecursiveTask subtask2 = new ArraySumRecursiveTask(arr, mid, end);
            /*
            * In this case, fork( ) is used because it starts a task but does not wait for it to finish. (Thus,
            * it asynchronously runs the task.)
            * */
            subtask1.fork();
            subtask2.fork();
            /**
            *This statement waits until each task ends. It then adds the results of each and assigns the
             * total to sum. Thus, the summation of each subtask is added to the running total. Finally,
             * compute( ) ends by returning sum, which will be the final total when the first invocation
             * returns.
             * There are other ways to approach the handling of the asynchronous execution of the
             * subtasks. For example, the following sequence uses fork( ) to start subTaskA and uses
             * invoke( ) to start and wait for subTaskB:
             * subTaskA.fork();
             * sum = subTaskB.invoke() + subTaskA.join();
             * Another alternative is to have subTaskB call compute( ) directly, as shown here:
             * subTaskA.fork();
             * sum = subTaskB.compute() + subTaskA.join();
            *
            *
            * */
            sum = sum + subtask1.join() + subtask2.join();
        }
        return sum;


    }
}
