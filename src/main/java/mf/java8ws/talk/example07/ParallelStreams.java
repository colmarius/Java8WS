package mf.java8ws.talk.example07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1) // this is an infinite stream
                    .limit(n)
                    .reduce(Long::sum).get(); // returns an Optional need to call .get()
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .parallel() // Laziness plays against us. Fork/Join framework is taking a lot of time to catchup.
                .limit(n)
                .reduce(Long::sum).get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .limit(n)
                .reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel() // Fork/Join framework works better in this case.
                .limit(n)
                .reduce(Long::sum).getAsLong();
    }
}
