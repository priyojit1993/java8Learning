package javaConcurrency.fork_join_framework_demo.recursiveTaskDemo;

public class RecursiveTaskDemo {
    public static void main(String[] args) {

        int[] ints = new int[100];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        ArraySumRecursiveTask arraySumRecursiveTask = new ArraySumRecursiveTask(ints, 0, ints.length);
        Integer sum = arraySumRecursiveTask.invoke();
        System.out.println(sum);
    }
}
