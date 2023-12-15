package javaadvanced.thread;

public class ThreadMethodExample {
  public static void main(String[] args) throws InterruptedException {
    // Create two threads
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        System.out.println("Thread 1 is running: " + i);
        try {
          Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 6; i++) {
        System.out.println("Thread 2 is running: " + i);
        try {
          Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    // Start both threads
    thread1.start();
    thread2.start();

    try {
      // Use join(4000) to wait for 4000ms or till thread1 finish
      thread1.join(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Once thread1 is finished, continue with the main thread
    System.out.println("Thread 1 has finished. Main thread continues.");

    // Use join() to wait for thread2 to finish
    try {
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Once thread2 is finished, continue with the main thread
    System.out.println("Thread 2 has finished. Main thread continues.");


    Thread thread3 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        System.out.println("Thread 3 is running: " + i);
        try {
          Thread.sleep(1000); // Sleep for 1 second
        } catch (InterruptedException e) {
          // Handle interruption
          System.out.println("Thread interrupted!");
        }
      }
    });
    thread3.start();
    try {
      Thread.sleep(3000);
      thread3.interrupt();
      System.out.println("Is thread interrupted: " + thread3.isInterrupted()); // Check if thread ís interrupted or not
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
