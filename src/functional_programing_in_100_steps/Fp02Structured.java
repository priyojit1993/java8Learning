package functional_programing_in_100_steps;

import java.util.List;

public class Fp02Structured {
    public static void sumOfLists(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 45, 67, 88, 95, 23, 45, 24, 12);
        sumOfLists(numbers);
    }
}
