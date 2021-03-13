import java.util.concurrent.atomic.LongAdder;

class Main {

    private static final int STORESNUMBER = 3;
    public static void main(String[] args) {

        LongAdder sum = new LongAdder();

        Store[] stores = new Store[STORESNUMBER];
        for (int i = 0; i < STORESNUMBER; i++) {
            stores[i] = new Store(sum);
        }

        for (Store shop : stores) {
            shop.start();
        }

        for (Store shop : stores) {
            try {
                shop.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Результат: " + sum.sum());

    }
}
