package functional_programing_in_100_steps;

import java.util.stream.LongStream;

public class Fp07ParallelizingStreams {
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(LongStream.rangeClosed(0, 1000000000).parallel().sum());
        System.out.println(System.currentTimeMillis() - l);
        //without using parallel it took 500 ms and with parallel it took 95 ms , internally parallel uses for join framework to divide the operation into smaller operations and join the result of each parts
    }
}
