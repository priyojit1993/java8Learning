package functional_programing_in_100_steps;

import java.util.List;

public class FP01StructuredApproach {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 45, 67, 88, 95, 23, 45,24,12);
//        printAllInListStructured(numbers);
        printAllEvenInListsStructured(numbers);
    }

    public static void printAllInListStructured(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.println(number);
        }
    }

    //print only even numbers
    public static void printAllEvenInListsStructured(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 2 == 0)
                System.out.println(number);
        }
    }
}
