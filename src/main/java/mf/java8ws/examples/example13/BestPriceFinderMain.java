package mf.java8ws.examples.example13;

import java.util.List;
import java.util.function.Supplier;

public class BestPriceFinderMain {

    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        execute("sequential", () -> bestPriceFinder.findPriceSequential("myPhone"));
        execute("parallel", () -> bestPriceFinder.findPriceParallel("myPhone"));
        execute("composed CompletableFuture", () -> bestPriceFinder.findPrice("myPhone"));
        //bestPriceFinder.printPricesStream();
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
