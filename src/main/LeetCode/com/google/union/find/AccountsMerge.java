package com.google.union.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int N = accounts.size();
    int[] id = new int[N];
    for (int i=0; i<N; i++) id[i] = i;
    int idx = 0;
    Map<String, List<Integer>> map = new HashMap();
    // Time: O(A*lgN) A is all emails in all accounts
    for (List<String> account : accounts) {
      for (String email : account) {
        if (email.indexOf("@")==-1) continue; // skip the first name
        // if for an email, there is id, that means there is another account has this email. so should union that account with this one
        if (map.containsKey(email)) union(idx, map.get(email).get(0), id);
        else map.computeIfAbsent(email, o -> new ArrayList()).add(idx);
      }
      idx++;
    }

    Map<Integer, TreeSet<String>> res = new HashMap();
    // Time: O(N * lgA), since we use TreeSet
    for (int i=0; i<N; i++) {
      int size = accounts.get(i).size();
      int j = find(id, i);
      if (!res.containsKey(j)) res.put(j, new TreeSet());
      res.get(j).addAll(accounts.get(i).subList(1, size));

    }
    List<List<String>> resList = new ArrayList();
    for (Integer i : res.keySet()) {
      List<String> ls = new ArrayList(res.get(i));
      ls.add(0, accounts.get(i).get(0));
      resList.add(ls);
    }
    return resList;
  }

  private int find(int[] id, int i) {
    while (id[i]!=i) {
      id[i]= id[id[i]];
      i = id[i];
    }
    return i;
  }

  private void union(int i, int j, int[] id) {
    int p = find(id, i), q = find(id, j);
    if (p!=q) id[p] = q;
  }

  public static void main(String... args) {
    List<List<String>> list = new ArrayList<>();
    list.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
    list.add(Arrays.asList("John", "johnnybravo@mail.com"));
    list.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
    list.add(Arrays.asList("Mary", "mary@mail.com"));
    AccountsMerge accountsMerge = new AccountsMerge();
    accountsMerge.accountsMerge(list);
  }
}
