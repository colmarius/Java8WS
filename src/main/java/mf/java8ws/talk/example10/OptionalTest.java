package mf.java8ws.talk.example10;

import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class OptionalTest {

    @Test
    public void testMap() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("a", "5");
        param.put("b", "true");
        param.put("c", "-3");

        assertEquals(5, readDuration(param, "a"));
        assertEquals(0, readDuration(param, "b"));
        assertEquals(0, readDuration(param, "c"));
        assertEquals(0, readDuration(param, "d"));

        assertEquals(5, readDurationImproved(param, "a"));
        assertEquals(0, readDurationImproved(param, "b"));
        assertEquals(0, readDurationImproved(param, "c"));
        assertEquals(0, readDurationImproved(param, "d"));
    }

    public int readDuration(Map<String, String> params, String name) {
        String value = params.get(name);
        if (value == null) {
            return 0;
        }
        try {
            int i = Integer.parseInt(value);
            return (i > 0) ? i : 0;
        } catch(NumberFormatException nfe) {
            return 0;
        }
    }

    public int readDurationImproved(Map<String, String> params, String name) {
        return Optional.ofNullable(params.get(name))
                .flatMap(OptionalTest::string2int)
                .filter(i -> i > 0)
                        .orElse(0);
    }

    public static Optional<Integer> string2int(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch(NumberFormatException nfe) {
            return Optional.empty();
        }
    }
}
