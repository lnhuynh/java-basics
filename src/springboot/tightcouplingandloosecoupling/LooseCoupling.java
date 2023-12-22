package springboot.tightcouplingandloosecoupling;

import java.util.Arrays;

interface SortAlgorithm {
    void sort(int[] array);
}
class BubbleSortAlgorithm2 implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorted using bubble sort algorithm");
        Arrays.sort(array); //This is a placeholder for the bubble sort algorithm
    }
}
public class LooseCoupling {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 5, 19, 2};
        SortAlgorithm bubbleSortAlgorithm2 = new BubbleSortAlgorithm2();
        LooseCouplingService complexService = new LooseCouplingService(bubbleSortAlgorithm2);
        complexService.complexBusiness(array);
        System.out.println(Arrays.toString(array));
    }

}
class LooseCouplingService {
    private final SortAlgorithm sortAlgorithm;
    public LooseCouplingService(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }
    public void complexBusiness(int[] array) {
        sortAlgorithm.sort(array);
    }
}
