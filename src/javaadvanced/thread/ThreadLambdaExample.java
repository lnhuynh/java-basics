package javaadvanced.thread;

public class ThreadLambdaExample {
  private Thread t;
  private String threadName;

  ThreadLambdaExample(String name) {
    threadName = name;
    System.out.println("Creating " + threadName);
  }

  public static void main(String args[]) {
    System.out.println("Main thread running... ");

    ThreadLambdaExample R1 = new ThreadLambdaExample("Thread-1-HR-Database");
    R1.start();

    ThreadLambdaExample R2 = new ThreadLambdaExample("Thread-2-Send-Email");
    R2.start();

    System.out.println("Main thread stopped!!!");
  }

  public void start() {
    System.out.println("Starting " + threadName);
    if (t == null) {
      t = new Thread(() -> {
        System.out.println("Running " + threadName);
        try {
          for (int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
          }
        } catch (InterruptedException e) {
          System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
      }, threadName);
      t.start();
    }
  }
}
