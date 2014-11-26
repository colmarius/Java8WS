package mf.java8ws.talk.example11;

import java.util.function.Consumer;

public class LoanPattern {

    public static class Resource {

        private Resource() {
            System.out.println("Opening resource");
        }

        public void operate() {
            System.out.println("Operating on resource");
            throw new RuntimeException();
        }

        private void dispose() { System.out.println("Disposing resource"); }

        public static void withResource(Consumer<Resource> consumer) {
            Resource r = new Resource();
            try {
                consumer.accept(r);
            } finally {
                r.dispose();
            }
        }
    }

    public static void main(String... args) {
//        Resource r = new Resource();
//        try {
//            r.operate();
//        } finally {
//            r.dispose();
//        }

        Resource.withResource(r -> r.operate());

    }
}
