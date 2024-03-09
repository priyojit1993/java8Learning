package functional_programing_in_100_steps;

import java.util.List;
import java.util.function.*;

public class Fp01FunctionalInterfaces {
    public static void main(String[] args) {
        Predicate<Integer> evenNumberCheck = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Function<Integer, Integer> squareFunction = new Function<>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };
        Consumer<Integer> printConsumer = new Consumer<>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        BinaryOperator<Integer> integerBinaryOperator = new BinaryOperator<>() {

            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };


        List<Integer> numbers = List.of(11, 45, 67, 88, 95, 23, 45, 24, 12);
        numbers.stream().filter(evenNumberCheck).forEach(printConsumer);
        System.out.println("-----------------------------------------");
        numbers.stream().map(squareFunction).forEach(printConsumer);
        System.out.println("-----------------------------------------");
        System.out.println(numbers.stream().reduce(0,integerBinaryOperator));

    }
}
