package springboot.tightcouplingandloosecoupling;


import java.util.Arrays;

class BubbleSortAlgorithm1 {
  public void sort(int[] array) {
    System.out.println("Sorted using bubble sort algorithm");
    Arrays.sort(array); //This is a placeholder for the bubble sort algorithm
  }
}

public class TightCoupling {
  public static void main(String[] args) {
    int[] array = {1, 3, 2, 5, 19, 2};
    TightCouplingService complexService = new TightCouplingService();
    complexService.complexBusiness(array);
    System.out.println(Arrays.toString(array));
  }

}

class TightCouplingService {
  private final BubbleSortAlgorithm1 bubbleSortAlgorithm = new BubbleSortAlgorithm1();

  public TightCouplingService() {
  }

  public void complexBusiness(int[] array) {
    bubbleSortAlgorithm.sort(array);
  }
}
