package interview.amazon.onsite;

import java.util.*;

/**
 * A-> C, E
 * B-> E, G
 * C-> D, H
 * E-> H, G
 * H-> G
 * return a dependency for all nodes
 */
public class PackageDetector {
    Map<Character, Set<Character>> res = new HashMap<>();

    public void detectDependency(Map<Character, List<Character>> graph) {
        Set<Character> visited = new HashSet<>();
        for (Character v : graph.keySet()) {
            dfs(v, graph, visited, new HashSet<>());
        }
        for (Character c : res.keySet()) {
            System.out.print(c + "-> ");
            res.get(c).stream().forEach(o-> System.out.print(o + ", "));
            System.out.println();
        }
    }

    private void dfs(Character v, Map<Character, List<Character>> graph, Set<Character> visited, Set<Character> list) {
        if (visited.contains(v)) {
            list.addAll(res.get(v));
            list.add(v);
            return;
        }
        visited.add(v);
        Set<Character> cur = new HashSet<>();
        if (graph.containsKey(v) && graph.get(v).size() > 0) {
            for (Character neighbor : graph.get(v)) {
                dfs(neighbor, graph, visited, cur);
            }
        }
        res.put(v, cur);
        list.addAll(cur);
        list.add(v);
    }

    public static void main(String... args) {
        PackageDetector packageDetector = new PackageDetector();
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('A', Arrays.asList('C', 'E'));
        graph.put('B', Arrays.asList('G', 'E'));
        graph.put('C', Arrays.asList('D', 'H'));
        graph.put('E', Arrays.asList('H', 'G'));
        graph.put('H', Arrays.asList('G'));
        packageDetector.detectDependency(graph);
    }
}
