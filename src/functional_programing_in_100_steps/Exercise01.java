package functional_programing_in_100_steps;

import java.util.Comparator;
import java.util.List;

public class Exercise01 {
    // print only odd numbers from the list
    public static void printOddNumbersInList(List<Integer> numbers) {
        numbers.stream().filter(integer -> integer % 2 == 0).forEach(System.out::println);
    }

    //print all courses individually
    public static void printAllCourses(List<String> courses) {
        courses.forEach(System.out::println);
    }

    //print courses containing the word spring
    public static void printWordsContainingSpring(List<String> courses) {
        courses.stream()
                .filter(s -> s.toLowerCase().contains("spring"))
                .forEach(System.out::println);
    }

    //print courses whose name has atleast 4 letters
    public static void printWordsWithAtleast4Letters(List<String> courses) {
        courses.stream().filter(s -> s.length() >= 4).forEach(System.out::println);
    }

    public static void printCubeOfNumbersInList(List<Integer> numbers) {
        numbers.stream().map(integer -> Math.pow(integer, 3)).forEach(System.out::println);
    }
    public static void printNumberOfCharacterInList(List<String> courses){
        courses.stream().map(String::length).forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<String> courses = List.of("Spring", "Spring boot", "API", "Micorservices", "AWS", "PCP", "Azue", "Docker", "Kubernetes");
        List<Integer> numbers = List.of(11, 45, 67, 88, 95, 23, 45, 24, 12);
        printOddNumbersInList(numbers);
        System.out.println("-----------------------------------------");
        printAllCourses(courses);
        System.out.println("-----------------------------------------");
        printWordsContainingSpring(courses);
        System.out.println("-----------------------------------------");
        printWordsWithAtleast4Letters(courses);
        System.out.println("-----------------------------------------");
        printCubeOfNumbersInList(numbers);
        System.out.println("-----------------------------------------");
        printNumberOfCharacterInList(courses);



    }
}
