package javaadvanced;

public class AsyncSync {
  public static void main(String[] args) {
    Delete delete = new Delete();

    Thread thread1 = new Thread(delete);
    Thread thread2 = new Thread(delete);

    thread1.start();
    thread2.start();
  }
}

class Delete implements Runnable {
  int totalRecord = 1;

  private synchronized void delete() throws InterruptedException {
    if (totalRecord > 0) {
        Thread.sleep(1000);
        --totalRecord;
        System.out.println("Deleting record...");
    }
    else {
      System.out.println("Delete record failed");
    }
  }

  @Override
  public void run() {
    try {
      delete();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
