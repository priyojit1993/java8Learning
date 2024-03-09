package functional_programing_in_100_steps;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Fp06FlatMap {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring boot", "API", "Micorservices", "AWS", "PCP", "Azue", "Docker", "Kubernetes");
        List<String> courses2 = List.of("Spring", "Spring boot", "API", "Micorservices", "AWS", "PCP", "Azue", "Docker", "Kubernetes");
        //join the name of the elements in list of string separated by comma
        System.out.println(courses.stream().collect(Collectors.joining(",")));
        //map the courses splitting each courses into its characters
        System.out.println(courses.stream().map(s -> Arrays.stream(s.split("")).toList()).collect(Collectors.toList()));//by using normal map it will give a list of lists as for each element in the list the split function will create a new list of character and so the result of list<List<character>>
        // to overcome this and bring the result into one dimensional list we have to use flatmap
        System.out.println(courses.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
        //turples
        //[[Spring, Spring], [Spring, Spring boot], [Spring, API], [Spring, Micorservices], [Spring, AWS], [Spring, PCP], [Spring, Azue], [Spring, Docker], [Spring, Kubernetes], [Spring boot, Spring], [Spring boot, Spring boot], [Spring boot, API], [Spring boot, Micorservices], [Spring boot, AWS], [Spring boot, PCP], [Spring boot, Azue], [Spring boot, Docker], [Spring boot, Kubernetes], [API, Spring], [API, Spring boot], [API, API], [API, Micorservices], [API, AWS], [API, PCP], [API, Azue], [API, Docker], [API, Kubernetes], [Micorservices, Spring], [Micorservices, Spring boot], [Micorservices, API], [Micorservices, Micorservices], [Micorservices, AWS], [Micorservices, PCP], [Micorservices, Azue], [Micorservices, Docker], [Micorservices, Kubernetes], [AWS, Spring], [AWS, Spring boot], [AWS, API], [AWS, Micorservices], [AWS, AWS], [AWS, PCP], [AWS, Azue], [AWS, Docker], [AWS, Kubernetes], [PCP, Spring], [PCP, Spring boot], [PCP, API], [PCP, Micorservices], [PCP, AWS], [PCP, PCP], [PCP, Azue], [PCP, Docker], [PCP, Kubernetes], [Azue, Spring], [Azue, Spring boot], [Azue, API], [Azue, Micorservices], [Azue, AWS], [Azue, PCP], [Azue, Azue], [Azue, Docker], [Azue, Kubernetes], [Docker, Spring], [Docker, Spring boot], [Docker, API], [Docker, Micorservices], [Docker, AWS], [Docker, PCP], [Docker, Azue], [Docker, Docker], [Docker, Kubernetes], [Kubernetes, Spring], [Kubernetes, Spring boot], [Kubernetes, API], [Kubernetes, Micorservices], [Kubernetes, AWS], [Kubernetes, PCP], [Kubernetes, Azue], [Kubernetes, Docker], [Kubernetes, Kubernetes]]
        System.out.println(courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList()));

        //truples with same length
        //[[Spring, Docker], [API, AWS], [API, PCP], [AWS, API], [AWS, PCP], [PCP, API], [PCP, AWS], [Docker, Spring]]
        System.out.println(courses.stream().flatMap(course -> courses2.stream()
                .filter(course2 -> course2.length() == course.length())
                .map(course2 -> List.of(course, course2))).filter(strings -> !strings.get(0).equals(strings.get(1))).collect(Collectors.toList()));

        //all intermediate operations of stream are lazy operations they are executed only when we are executing the terminal operation , until that they generate streams as well
        //Spring
        //Spring boot
        //API
        //Micorservices
        //MICORSERVICES
        //Optional[MICORSERVICES]
        //here since the pipeline knows that the terminal operation is findFirst() so it based on the terminal operation it does not iterates the entire list prints the first element that matches the filter criteria via mapping
        System.out.println(courses.stream().peek(System.out::println).filter(s -> s.length() > 11).map(String::toUpperCase).peek(System.out::println).findFirst());
        ;
    }

    //creating a higher order function , a function which returns another function
    public static Predicate<String> checkLengthPredicate(int lengthToMatch) {
        Predicate<String> predicate = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.length() == lengthToMatch;
            }
        };
        return predicate;
    }

    //using lambda creating a higher order function
    public static Predicate<String> checkLengthPredicate2(int lengthToMatch) {
        return course -> course.length() == lengthToMatch;
    }
}
