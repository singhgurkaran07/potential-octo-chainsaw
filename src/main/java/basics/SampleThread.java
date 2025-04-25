package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread is running using run method...");
    }

    public static void main(String[] args) {

        // Lambdas are designed for concise implementations of functional interfaces, like Runnable.
        /*
        * Internally:
            The lambda expression () -> { System.out.println("..."); } creates an instance of Runnable.

            The Thread class takes this Runnable object as a parameter in its constructor.

            When thread.start() is called, it internally calls the run() method of the Runnable instance.


        * */

        Thread thread = new Thread( () -> System.out.println("Thread is running using Lambda expression..."));
        thread.start(); // internally calls run() method


        /*
        * For better thread management, you can use the ExecutorService framework,
        * which is part of the java.util.concurrent package.
        * */
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Thread is running using ExecutorService..."));
        executor.shutdown(); // Shut down the executor


        // using Runnable interface
        Thread runnableInterfaceImpl = new Thread(new SampleThread());
        runnableInterfaceImpl.start(); //starts the thread and executes run method
    }
}
