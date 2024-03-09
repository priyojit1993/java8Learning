package functional_programing_in_100_steps;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Fp05CreatingStreamUsingStreamClass {
    public static void main(String[] args) {
        //we are able to create a stream directly using Stream.of method similar to how we can create a list by list.of method
        System.out.println(Stream.of(11,12,45,6,8,91,14).count());
        System.out.println(Stream.of(11,12,45,6,8,91,14).reduce(0,Integer::sum));
         //when we do stream.of and pass primitive value in it then internally it boxes those into wrapper class object and creates a stream of those boxed values
        //to create stream of primitive value is much efficient as it reduces the boxing and unboxing overheads
        int[] arrays = {11, 12, 45, 6, 8, 91, 14};
        Stream<Integer> integerStream = Stream.of(11, 12, 45, 6, 8, 91, 14);//this creates a stream of Integer wrapper class by auto boxing the primitive values.
        IntStream intStream = Arrays.stream(arrays);//this will create an IntStream
        System.out.println(Arrays.stream(arrays).count());
        System.out.println(Arrays.stream(arrays).sum());
        System.out.println(Arrays.stream(arrays).average());
        // create stream of first 100 integer numbers
        IntStream range = IntStream.range(1, 101);//creates an intStream from n,m-1
        //to create a int stream with closed range
        IntStream rangeClosedIntStream = IntStream.rangeClosed(1, 100);
       //peek method is used to look into the stream without changing the actual stream
        System.out.println(IntStream.rangeClosed(1,100).peek(System.out::println).sum());

        //to perform operation on huge numbers we can use big integers
        System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(
                BigInteger.ONE,BigInteger::multiply
        ));
    }
}
