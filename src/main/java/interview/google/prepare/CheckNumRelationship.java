package interview.google.prepare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给一堆未知数之间大于小于的关系，判断所有关系之间是否成立。
 * 比如输入 a<b, b<c, a<c, 输出就是成立；输入 a<b, b<c, c<a, 输出就是不成立。符号仅限大于号和小于号
 * 本质可以转化为一道有向图找环的题，经典解法有很多，用dfs/bfs均可
 *
 * 然后follow up1是，如果输入端除了未知数还包含数字怎么办？
 * 比如输入 a>2, a<b, b<1，输出就是不成立
 * 这问相对简单，我的做法是把所有出现过的数字记录下来，在create有向图的时候按大小顺序把数字也加到有向图里，然后再用dfs/bfs找环即可
 *
 * 然后follow up2是，如果符号包含大于等于号，小于等于号怎么办？
 * 比如输入 a>b, b<=a，输出不成立；输入a>=b, b>=c, c>=a, 输出成立；
 * 这问感觉挺难，现场答的磕磕绊绊没完全做出来。面完之后又想了想觉‍‌‌‌‌‌‍‍‌‌‍‌‌‍‌‌‌‍‌‌得问的十分精彩
 * 我的想法是
 * 1.首先先忽略等于号的存在create有向图。
 * 2.然后求图的strongly connected component。
 * 3.然后输入端成立的充要条件是所有scc内部的连接都必须带等号
 * 其实本质也是将问题转化成现有的经典数据结构问题：有向图中求scc。
 */
public class CheckNumRelationship {

  public static boolean checkNumRelationship(Map<String, List<String>> graph) {
    // from each point, do dfs, check whether there is a cycle
    Set<String> visited = new HashSet<>();
    for (String point : graph.keySet()) {
      Set<String> currentSet = new HashSet<>();
      if (!dfs(point, graph, visited, currentSet)) return false;
    }
    return true;
  }

  private static boolean dfs(String point, Map<String, List<String>> graph, Set<String> visited, Set<String> currentSet) {
    if (visited.contains(point)) return true;
    if (currentSet.contains(point)) return false;
    currentSet.add(point);
    if (graph.containsKey(point) && graph.get(point).size() > 0) {
      for (String neighbor : graph.get(point)) {
        if (!dfs(neighbor, graph, visited, currentSet)) return false;
      }
    }
    currentSet.remove(point);
    visited.add(point);
    return true;
  }

  public static void main(String... args) {
    Map<String, List<String>> graph = new HashMap<String, List<String>>() {
      {
        put("a", Arrays.asList("b", "c"));
        put("b", Arrays.asList("c"));
        put("c", Arrays.asList("a", "e", "f"));
        put("d", Arrays.asList("e", "f"));
      }
    };

    System.out.println(CheckNumRelationship.checkNumRelationship(graph));
  }
}
