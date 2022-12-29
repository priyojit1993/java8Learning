package multithreading.synchronizedBlock;

public class PrintDummy {

    public  void callMe(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("]");
        System.out.println();

    }


}
