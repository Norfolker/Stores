import java.util.concurrent.atomic.LongAdder;
import java.util.Random;

public class Store extends Thread {

    private static final int sellsCount = 15;
    private static final int maxPrice = 1000;
    private LongAdder sum;
    private int[] sells;

    public Store(LongAdder sum) {
        this.sum = sum;
        this.sells = generateSells(sellsCount);
    }

    private static int[] generateSells(int length) {
        Random rand = new Random();
        int[] result = new int[length];
        for(int i = 0; i < length; i++) {
            result[i] = rand.nextInt(maxPrice);
        }
        return result;
    }

    public void run() {
        for (int sell : sells) {
            sum.add(sell);
        }
    }

}
