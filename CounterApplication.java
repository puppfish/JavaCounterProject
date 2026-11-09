
package JavaCounterProject;

public class CounterApplication {

    public static void main(String[] args) {

        // Thread 1: Count up from 1 to 20
        Thread thread1 = new Thread(() -> {

            System.out.println("Thread 1: Counting Up");

            for (int i = 1; i <= 20; i++) {

                System.out.println("Count Up: " + i);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread 1 was interrupted.");
                    return;
                }
            }

            System.out.println("Thread 1 finished!");
        });

        // Thread 2: Count down from 20 to 0
        Thread thread2 = new Thread(() -> {

            System.out.println("Thread 2: Counting Down");

            for (int i = 20; i >= 0; i--) {

                System.out.println("Count Down: " + i);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread 2 was interrupted.");
                    return;
                }
            }

            System.out.println("Thread 2 finished!");
        });

        // Start Thread 1
        thread1.start();

        // Wait for Thread 1 to finish
        try {
            thread1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
            return;
        }

        // Start Thread 2 after Thread 1 completes
        thread2.start();

        // Wait for Thread 2 to finish
        try {
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }

        System.out.println("Both threads have completed!");
    }
}
