package multithreading.interThreadComunication;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        System.out.println("Press Control-C to stop.");
    }
}
