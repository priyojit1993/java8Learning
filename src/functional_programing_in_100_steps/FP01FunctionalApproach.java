package functional_programing_in_100_steps;

import java.util.List;

public class FP01FunctionalApproach {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 45, 67, 88, 95, 23, 45, 24, 12);
        // printAllNumbersInListFunctional(numbers);
//        printAllEvenInListsFunctional(numbers);
        printAllEvenInListFunctionalUsingLambda(numbers);
    }

    public static void print(Integer number) {
        System.out.println(number);
    }

    public static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static void printAllEvenInListsFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(FP01FunctionalApproach::isEven)//Filter - only allow even numbers
                .forEach(FP01FunctionalApproach::print);
    }

    public static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // what to do?
        //convert list of numbers into stream/sequence of numbers
        numbers.forEach(FP01FunctionalApproach::print);//using method reference ClassName::MethodName to reference the method inside the lambda function
        //approach to using system reference method
        System.out.println("-------------------------------------------------------------------------");
        numbers.forEach(System.out::println);
    }

    public static void printAllEvenInListFunctionalUsingLambda(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 == 0)// filter using lambda expersion instead of a separate function
                .forEach(FP01FunctionalApproach::print);
    }
}
