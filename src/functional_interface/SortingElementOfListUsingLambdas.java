package functional_interface;

import java.util.Arrays;
import java.util.List;

public class SortingElementOfListUsingLambdas {
    /*
     * Here we will use the comparator functional interface
     *
     * */
    public static void main(String[] args) {


        List<Integer> integers = Arrays.asList(1, 2, 44, 7, 8, 5, 9, 6);
        integers.sort((Integer a1, Integer a2) -> {
            if (a1 > a2)
                return 1;
            else if (a1 < a2)
                return -1;
            else return 0;
        });
        System.out.println(integers);
    }


}
