package temp;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckPoolAndText {

    public static void main(String... args) {
        boolean res1 = check("Hello World", "WorldHello");
        boolean res2 = check("abc", "bca");
        System.out.println(res1);
        System.out.println(res2);
    }

    private static boolean check(String pool, String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : pool.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<String> list = new ArrayList<>();

        list.add("Hello");
        list.add("Hello");
        list.add("World");

        Map<String, Long> counted = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (char c : text.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c)<0) return false;
        }
        return true;
    }
}
