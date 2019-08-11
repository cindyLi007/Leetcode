package temp;

import java.util.*;

public class Solutions_3 {
    public static String[] findOcurrences(String text, String first, String second) {
        String target = first + " " + second;
        int i = 0, N = text.length();
        List<String> res = new ArrayList();
        while (i>=0 && i<N) {
            int idx = text.indexOf(target, i);
            if (idx>=0) {
                int start = idx + target.length() + 1;
                int end = text.indexOf(" ", start);
                res.add(text.substring(start, end < 0 ? N : end));
                i = start;
            } else break;
        }
        return res.stream().toArray(n -> new String[n]);
        /*String[] r = new String[res.size()];
        i=0;
        for (String s : res) r[i++] = s;
        return r;*/
    }

    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int N = values.length;
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int i=0; i<N; i++) {
            pq.offer(new Item(values[i], labels[i]));
        }
        int res = 0;
        Set<Integer> visited = new HashSet();
        while (!pq.isEmpty() && num_wanted>0) {
            Item cur = pq.poll();
            if (!visited.add(cur.label)) continue;
            res+=cur.v;
            num_wanted--;
        }
        return res;
    }

    class Item implements Comparable<Item>{
        int v, label;
        Item(int v, int l) {
            this.v=v;
            label=l;
        }

        public int compareTo(Item o) {
            return o.v - this.v;
        }
    }

    public static void main(String... args) {
//        String[] ocurrences = findOcurrences("alice is a good girl she is a good student", "a", "good");
        String[] ocurrences = findOcurrences("we will we will rock you", "we", "will");
        Arrays.stream(ocurrences).forEach(o-> System.out.println(o));
    }
}
