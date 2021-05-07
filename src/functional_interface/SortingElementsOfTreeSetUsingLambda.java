package functional_interface;

import java.util.TreeSet;

public class SortingElementsOfTreeSetUsingLambda {

    class Student {
        private int roll;
        private String name;

        public Student(int roll, String name) {
            this.roll = roll;
            this.name = name;
        }

        public int getRoll() {
            return roll;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "roll=" + roll +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    /*
     * We will use  lambdas to create a treeSet with custom comparator
     * */
    public static void main(String[] args) {
        SortingElementsOfTreeSetUsingLambda sortingElementsOfTreeSetUsingLambda = new SortingElementsOfTreeSetUsingLambda();
        Student rahul = sortingElementsOfTreeSetUsingLambda.new Student(12, "Rahul");
        Student Priyojit = sortingElementsOfTreeSetUsingLambda.new Student(14, "Priyojit");
        Student Rishab = sortingElementsOfTreeSetUsingLambda.new Student(1, "Rishab");
        Student Rajesh = sortingElementsOfTreeSetUsingLambda.new Student(2, "Rajesh");
        Student Sagarika = sortingElementsOfTreeSetUsingLambda.new Student(15, "Sagarika");
        Student Meghnad = sortingElementsOfTreeSetUsingLambda.new Student(6, "Meghnad");

        TreeSet<Student> students = new TreeSet<>((Student s1, Student s2) -> {
            if (s1.getRoll() > s2.getRoll())
                return 1;
            else if (s1.getRoll() < s2.getRoll())
                return -1;
            else return 0;
        });
        students.add(rahul);
        students.add(Priyojit);
        students.add(Rajesh);
        students.add(Sagarika);
        students.add(Rajesh);
        students.add(Meghnad);
        for (Student student : students) {
            System.out.println(student.toString());
        }

    }


}
