package functional_programing_in_100_steps;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 45, 67, 88, 95, 23, 45, 24, 12);
        Predicate<Integer> oddPredicate = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return !(integer % 2 == 0);
            }
        };
        Predicate<Integer> evenPredicate = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Consumer<Integer> integerConsumer = new Consumer<>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        printOddOrEven(numbers, evenPredicate, integerConsumer);
        System.out.println("-------------------------------");
        printOddOrEven(numbers, oddPredicate, integerConsumer);


    }

    //here in this function the two parameters predicate and integerConsumer are example of behavior parameterization as we are passing the behaviour or another function as argument to this function which dictates the behaviour of the function
    public static void printOddOrEven(List<Integer> numbers, Predicate<Integer> predicate, Consumer<Integer> integerConsumer) {
        numbers.stream().filter(predicate).forEach(integerConsumer);
    }
}
