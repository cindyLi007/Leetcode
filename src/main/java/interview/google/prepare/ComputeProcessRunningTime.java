package interview.google.prepare;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given an execution log of entry time and exit time of several functions during an execution. can you make a
 * file-system-like directory telling me the duration of each functions runtime?
 * something like this -> Func1 08:00 func 2 08:01 func3 08:02 func3 08:03 func2 08:04 func1 08:05
 * These are execution times when function start executing and when it was finished.
 * OP suggested to read these logs, whenever encountered starting time, push the remaining methods in child tree until you encounter the node closing time.
 * so for above log output hierarchy will be Func1(parent) -> Func2 (parent of Func 3) -> Func 3
 */
public class ComputeProcessRunningTime {
  int idx;

  // process should be [label, timestamp] for simplicity, timestamp < 0 means end, otherwise means start
  // Time: O(N)
  public NaryTreeNode computeProcess(int[][] processes) {
    NaryTreeNode root = new NaryTreeNode(0, 0); // create a dummy root
    idx = 0;
    while (idx<processes.length) {
      root.subFunctions.add(parse(processes));
    }
    return root;
  }

  // if we enter this method, we know curPAndT is a start
  private NaryTreeNode parse(int[][] processes) {
    int[] curPAndT = processes[idx++];
    NaryTreeNode naryTreeNode = new NaryTreeNode(curPAndT[0], curPAndT[1]);
    int sumOfSubFunctions = 0;
    while (idx < processes.length && processes[idx][1] > 0) {
      // enter this point means naryTreeNode has children node
      NaryTreeNode subFunction = parse(processes);
      naryTreeNode.subFunctions.add(subFunction);
      sumOfSubFunctions += subFunction.duration;
    }
    naryTreeNode.endTime = Math.abs(processes[idx][1]);
    naryTreeNode.duration = naryTreeNode.endTime - naryTreeNode.startTime;
    naryTreeNode.runningTime = naryTreeNode.duration - sumOfSubFunctions;
    idx++;
    return naryTreeNode;
  }

  public static void main(String... args) {
    ComputeProcessRunningTime computeProcessRunningTime = new ComputeProcessRunningTime();
    int[][] processes = new int[][]{{111, 801}, {112, 802}, {112, -805}, {111, -806}, {113, 813}, {113, -814}};
    NaryTreeNode naryTreeNode = computeProcessRunningTime.computeProcess(processes);
    System.out.println("done");
  }
}

class NaryTreeNode {
  int label;
  int startTime, endTime, runningTime, duration;
  List<NaryTreeNode> subFunctions;

  NaryTreeNode(int label, int startTime) {
    this.label = label;
    this.startTime = startTime;
    subFunctions = new LinkedList<>();
    runningTime = 0; // the real exe time
  }

}
