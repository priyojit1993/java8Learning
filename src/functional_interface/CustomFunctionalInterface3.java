package functional_interface;

public class CustomFunctionalInterface3 {
    /*
     * Functional interface that 2ill take two numbers and  return their product as output
     *
     *  */

    @FunctionalInterface
    interface FunctionalInterfaceReturnProduct {
        int getProduct(int a, int b);
    }

    public static void main(String[] args) {
        FunctionalInterfaceReturnProduct functionalInterfaceReturnProduct = (a, b) -> a * b;
        int product = functionalInterfaceReturnProduct.getProduct(12, 4);
        System.out.println("product of 2 numbers are : " + product);
    }
}



