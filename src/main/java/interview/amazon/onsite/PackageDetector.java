package interview.amazon.onsite;

import java.util.*;

/**
 * A-> C, E
 * B-> E, G
 * C-> D, H
 * E-> H, G
 * H-> G
 * return a dependency for all nodes,
 * this one is similar withe EPI TaskSchedule
 */
public class PackageDetector {
  Map<Character, Set<Character>> res = new HashMap<>();

  // Time: O(V+E), Space: O(V)
  public void detectDependency(Map<Character, List<Character>> graph) {
    for (Character v : graph.keySet()) {
      dfs(v, graph);
    }
    for (Character c : res.keySet()) {
      System.out.print(c + "-> ");
      res.get(c).stream().forEach(o -> System.out.print(o + ", "));
      System.out.println();
    }
  }

  private Set<Character> dfs(Character v, Map<Character, List<Character>> graph) {
    if (res.containsKey(v)) {
      return res.get(v);
    }

    Set<Character> cur = new HashSet<>();
    if (graph.containsKey(v) && !graph.get(v).isEmpty()) {
      for (Character neighbor : graph.get(v)) {
        cur.add(neighbor);
        cur.addAll(dfs(neighbor, graph));
      }
    }
    res.put(v, cur);
    return cur;
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
