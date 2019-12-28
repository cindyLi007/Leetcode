package interview.google.prepare.onsite.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Given a log file in which each line is a log, the format is prefix <userName> text words list, for exampel
 * microsoft Azure <grchan> !test !Google   get offer (should be 4 words)
 * !@google Dream <cindy> Google test user
 * read the file and return the top N user with most text words
 * we can assume the line is well-formed
 */
public class TopNUsersWithMostWords {

  // Time: O(L * length of each line in file + M * lgN), L is the # of lines in the file, M is the entry in map file, N is the parameter
  // Space: O(M)
  public List<String> topN_user(String file, int N) {
    Map<String, Integer> counter = new HashMap<>();

    // 1st parse line in the file to render a <userName, countWords> map
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        parse(line, counter);
      }
    } catch (Exception e) {

    }

    // 2nd use the PriorityQueue to render top N users with most words
    PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));
    for (String userName : counter.keySet()) {
      if (pq.size() == N && counter.get(userName) < pq.peek().count) continue;
      pq.offer(new Item(userName, counter.get(userName)));
      if (pq.size() > N) pq.poll();
    }

    // reder the final list for the top N users
    List<String> res = pq.stream().map(o -> o.user).collect(Collectors.toList());
    Collections.reverse(res);

    return res;
  }

  class Item {
    String user;
    int count;

    Item(String u, int c) {
      user = u;
      count = c;
    }
  }

  private void parse(String line, Map<String, Integer> counter) {
    String name = line.substring(line.indexOf("<") + 1, line.indexOf(">"));
    int start = line.indexOf(">") + 1;
    int length = line.length();
    for (int i = start; i < length; i++) {
      while (i<length && !Character.isLetter(line.charAt(i))) i++;
      if (i==length) break;
      while (i<length && Character.isLetter(line.charAt(i))) i++;
      counter.put(name, counter.getOrDefault(name, 0) + 1);
    }
    System.out.println(name + " words count is " + counter.get(name));
  }

  public static void main(String... args) {
    TopNUsersWithMostWords topNUsersWithMostWords = new TopNUsersWithMostWords();
    List<String> users = topNUsersWithMostWords.topN_user("C:\\Users\\grchan\\IdeaProjects\\Leetcode\\src\\main\\java\\" +
        "interview\\google\\prepare\\onsite\\interview\\topNUserTest.txt", 3);
    users.stream().forEach(u -> System.out.print(u + ", "));
    System.out.println();
  }
}
//gchang, ychang3, grchang,
