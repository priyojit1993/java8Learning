package javaConcurrency.fork_join_framework_demo.recursiveActionDemo;
/**
 * As you can see, the values of the array elements have been transformed into their square roots.
 * Let’s look closely at how this program works. First, notice that SqrtTransform is a class
 * that extends RecursiveAction. As explained, RecursiveAction extends ForkJoinTask for
 * tasks that do not return results. Next, notice the final variable seqThreshold. This is the
 * value that determines when sequential processing will take place. This value is set (somewhat
 * arbitrarily) to 1,000. Next, notice that a reference to the array to be processed is stored in
 * data and that the fields start and end are used to indicate the boundaries of the elements
 * to be accessed.
 * The main action of the program takes place in compute( ). It begins by checking if the
 * number of elements to be processed is below the sequential processing threshold. If it is,
 * then those elements are processed (by computing their square root in this example). If the
 * sequential processing threshold has not been reached, then two new tasks are started by
 * calling invokeAll( ). In this case, each subtask processes half the elements. As explained
 * earlier, invokeAll( ) waits until both tasks return. After all of the recursive calls unwind, each
 * element in the array will have been modified, with much of the action taking place in
 * parallel (if multiple processors are available).
 *
 * As mentioned, beginning with JDK 8, it is not necessary to explicitly construct a
 * ForkJoinPool because a common pool is available for your use. Furthermore, using the
 * common pool is a simple matter. For example, you can obtain a reference to the common
 * pool by calling the static commonPool( ) method defined by ForkJoinPool.
 *
 * Alternatively, there is no need to explicitly obtain a reference to the common pool
 * because calling the ForkJoinTask methods invoke( ) or fork( ) on a task that is not already
 * part of a pool will cause it to execute within the common pool automatically
 *
 *
 *
 *
 * */
public class ForkJoinDemo1 {

    public static void main(String[] args) {
        double[] doubles = new double[1000000];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = i;
        }
        SquareForkTask squareForkTask = new SquareForkTask(doubles, 0, doubles.length);
        squareForkTask.invoke();
        for (int i = 0; i < 10; i++) {
            System.out.println(String.format("%.4f ", doubles[i]));
        }
    }

}
