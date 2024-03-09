package functional_programing_in_100_steps;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FP02Functional {
    public static void sumOfLists(List<Integer> numbers) {
        int sum = numbers.stream()
                //.reduce(0,FP02Functional::sum) //without using lamabda
                //.reduce(0, (x, y) -> x + y)
                .reduce(0, Integer::sum); //using lambda expression using sum method reference of integer class
        System.out.println("sum = " + sum);
    }
    public static void distinctElementsFromList(List<Integer> numbers){
        // gets all the distinct numbers form the list removing the duplicates
        numbers.stream().distinct().forEach(System.out::println);
    }
    public static void sortedElementsFromList(List<Integer> numbers){
        // sort the list keeping duplicates
        numbers.stream().sorted().forEach(System.out::println);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(11, 45, 67, 88,11,23, 95, 23, 45, 24, 12);
//        numbers.stream().map(value -> Math.pow(value,3)).reduce(Double::sum).get()
        /*   int sum = 0;
       int x = 0, y = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(x);
            sum = x + y;
            y = x;
            x = sum;
        }*/
//        sumOfLists(numbers);
        distinctElementsFromList(numbers);
        System.out.println("---------------------------");
        sortedElementsFromList(numbers);

    }
}
