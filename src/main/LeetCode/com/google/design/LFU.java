package com.google.design;

import java.util.*;


class LFU {
    TreeMap<Integer, List<Item>> freqToItem;
    Map<Integer, Item> vals;
    int c;

    public LFU(int capacity) {
        c=capacity;
        vals = new HashMap();
        freqToItem = new TreeMap();
    }

    public int get(int key) {
        if (!vals.containsKey(key)) return -1;
        Item res = vals.get(key);
        freqToItem.get(res.freq).remove(res);
        if (freqToItem.get(res.freq).size()==0) freqToItem.remove(res.freq);
        res.freq++;
        freqToItem.computeIfAbsent(res.freq, k -> new ArrayList()).add(res);
        vals.put(res.key, res);
        return res.val;
    }

    public void put(int key, int value) {
        if (c==0) return;
        if (vals.containsKey(key)) {
            Item res = vals.get(key);
            res.val = value;
            get(res.key);
        } else {
            if (vals.size() == c) {
                int k = freqToItem.firstKey();
                Item item = freqToItem.get(k).remove(0);
                if (freqToItem.get(k).size() == 0) freqToItem.remove(k);
                vals.remove(item.key);
            }
            Item res = new Item(key, value, 1);
            vals.put(key, res);
            freqToItem.computeIfAbsent(res.freq, k -> new ArrayList()).add(res);
        }
    }

    class Item {
        int key, val, freq;

        Item(int k, int v, int f) {
            key = k;
            val = v;
            freq = f;
        }
    }

    public static void main(String... args) {
        LFU lfu = new LFU(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        int res = lfu.get(1);
        System.out.println(res);
        lfu.put(3, 3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4, 4);
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
    }
}
