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
 * When you have a sequence of numbers in the input, like 1,2,3,4, then you add the following pairs into the input,
 * 1<2, 2<3, 3<4, then these will be enough for you to construct the whole graph.
 *
 * 然后follow up2是，如果符号包含大于等于号，小于等于号怎么办？
 * 比如输入 a<b, b<=a，输出不成立；输入a>=b, b>=c, c>=a, 输出成立；
 * 这问感觉挺难，现场答的磕磕绊绊没完全做出来。面完之后又想了想觉‍‌‌‌‌‌‍‍‌‌‍‌‌‍‌‌‌‍‌‌得问的十分精彩
 * 我的想法是
 * 1.首先先忽略等于号的存在create有向图。
 * 2.然后求图的strongly connected component。
 * 3.然后输入端成立的充要条件是所有scc内部的连接都必须带等号
 * 其实本质也是将问题转化成现有的经典数据结构问题：有向图中求scc。
 * 我的办法是用map<string,map<string,bool>>来储存这些关系，比如a>=c，我们就给他存成map[a][c]=true，a>c就给存成map[a][c]=false。
 * 这样我们就能看一个cycle里面这个相等的关系是不是一直能传递下去，如果不能，那就证明存在环，如果这个等于能与之传递下去，就证明这个不是环。
 */
public class CheckNumRelationship {

  // 这是用DFS来做，也可以用BFS来做，就是从所有inDegree ==0 的Vertex 开始BFS，如果一个Vertex在减去它的Source Vertex以后InDegree==0，
  // 就把它加入Queue，最后queue 为空的的时候看所遍历的Vertex是不是等于图中所有的Vertex
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
    // 如果一个vertex已经被visited过 则说明从它开始的所有edge没有cycle, we can skip it
    if (visited.contains(point)) return true;
    // if a vertex is in current path, that means it appears in this path previously
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

  public static boolean checkNumCycle(Map<String, List<Edge>> graph) {
    Set<String> visited = new HashSet<>();
    for (String point : graph.keySet()) {
      Set<String> curSet = new HashSet<>();
      if (!dfs_1(point, graph, visited, curSet, true)) return false;
    }
    return true;
  }

  private static boolean dfs_1(String v, Map<String, List<Edge>> graph, Set<String> visited, Set<String> curSet, boolean includeEqual) {
    if (visited.contains(v)) return true;
    if (curSet.contains(v)) return includeEqual;
    curSet.add(v);
    if (graph.containsKey(v) && graph.get(v).size() > 0) {
      for (Edge n : graph.get(v)) {
        boolean e = n.includeEqual & includeEqual;
        String next = n.targetVertex;
        if (!dfs_1(next, graph, visited, curSet, e)) return false;
      }
    }
    curSet.remove(v);
    visited.add(v);
    return true;
  }

  private static class Edge {
    String targetVertex;
    boolean includeEqual;

    Edge(String t, boolean e) {
      targetVertex = t;
      includeEqual = e;
    }
  }

  public static void main(String... args) {
    Map<String, List<String>> graph = new HashMap<String, List<String>>() {
      {
        put("a", Arrays.asList("b", "c"));
        put("b", Arrays.asList("c"));
        put("c", Arrays.asList("d", "e", "f"));
        put("d", Arrays.asList("e", "f"));
      }
    };
    System.out.println(CheckNumRelationship.checkNumRelationship(graph));

    Map<String, List<Edge>> graph_followup2= new HashMap<String, List<Edge>>() { // should return false
      {
        put("b", Arrays.asList(new Edge("c", false)));
        put("c", Arrays.asList(new Edge("a", true)));
        put("a", Arrays.asList(new Edge("b", true), new Edge("c", false)));
      }
    };

    /* Map<String, List<Edge>> graph_followup2= new HashMap<String, List<Edge>>() { // should return true
      {
        put("b", Arrays.asList(new Edge("a", true)));
        put("c", Arrays.asList(new Edge("b", true)));
        put("a", Arrays.asList(new Edge("c", true)));
      }
    }; */

    System.out.println(checkNumCycle(graph_followup2));
  }
}
