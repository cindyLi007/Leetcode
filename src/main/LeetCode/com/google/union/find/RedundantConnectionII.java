package com.google.union.find;

public class RedundantConnectionII {

  public int[] findRedundantDirectedConnection(int[][] edges) {
    // in a valid D-tree, each node should have inDegree == 1, only one has node inDegree==0, that is the root
    // if one node has inDegree == 2, one of the edge must be removed, if there is no node with inDegree=2, there is must
    // a cycle, we can remove any edge which in the cycle; however, it there is one node with inDegree==2 and a cycle,
    // there is one and only one edge of the 2 edges leading-the-inDegree==2 in the cycle, we should remove that one
    int V = edges.length;
    int[] parent = new int[V+1];
    // can1 and can2 stands for 2 edges pointing same nodes
    int[] can1 = new int[0], can2 = new int[0];
    for (int[] edge : edges) {
      int source = edge[0], child = edge[1];
      if (parent[child]!=0) {
        // can1 appears earlier than can2
        can1 = new int[]{parent[child], child};
        can2 = new int[]{edge[0], edge[1]};
        // remove the inDegree==2 edge, so now the graph can only have cycle
        edge[1] = 0;
      }
      parent[child] = source;
    }

    // check whether there is a cycle
    int[] id = new int[V+1];
    for (int i=0; i<=V; i++) id[i]=i;
    for (int[] edge : edges) {
      // ignore one of the inDegree==2 edge
      if (edge[1]==0) continue;
      int source = edge[0], child = edge[1];
      // 由于我们removed一条inDegree==2的edge, find(id, source)一定是一个inDegree为0 或为1的点，由于source指向child，
      // child必然没有其他的祖先, 在source指向他之前它的id一定是他本身
      if (find(id, source) == child) { // there is a cycle
        if (can1.length==0) {
          return edge;
        } else { //
          // 之所以一定是can1 是因为我们已经把can2 removed 了，这时还会造成环就一定是can1引起的
          return can1;
        }
      }
      id[child]=source;
    }
    return can2;
  }

  private int find(int[] id, int i) {
    while (id[i]!=i) {
      id[i]=id[id[i]];
      i = id[i];
    }
    return i;
  }

  public static void main(String... args) {
    RedundantConnectionII redundantConnectionII = new RedundantConnectionII();
    int[][] tree = {{4, 1}, {1, 2}, {2, 3}, {3, 1}};
    int[] redundantDirectedConnection = redundantConnectionII.findRedundantDirectedConnection(tree);
    System.out.println(redundantDirectedConnection[0] + " - " + redundantDirectedConnection[1]);
  }
}
