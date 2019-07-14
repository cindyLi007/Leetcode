package com.google.dp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * price   [2,3,4],
 * special [[1,1,0,4],[2,2,1,9]],
 * needs   [1,2,1]
 */
public class ShoppingOffer {
    Map<String, Integer> map = new HashMap();
    // recursive + memorization, each round
    // 1. first render sum WITHOUT use special
    // 2. go through each special, for valid one, use once, update the "needs" list
    // 3. recursively call for update needs, until no special coupon can be used.
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int N=price.size();
        // we can directly use Object.toString to render hash key
        String key = needs.toString();
        if (map.containsKey(key)) return map.get(key);

        int res = sum(price, needs);
        for (List<Integer> spe : special) {
            List<Integer> clone = new ArrayList(needs);
            for (int i=0; i<N && clone!=null; i++) {
                if (spe.get(i)>needs.get(i)) clone=null;
                else clone.set(i, clone.get(i)-spe.get(i));
            }
            // end point, if no any special can be used (all return clone==null)
            if (clone!=null) {
                res = Math.min(res, shoppingOffers(price, special, clone) + spe.get(N));
            }
        }
        map.put(key, res);
        return res;
    }

    private int sum(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for (int i=0; i<price.size(); i++) res+=price.get(i)*needs.get(i);
        return res;
    }

    public static void main(String... args) {
        ShoppingOffer shoppingOffer = new ShoppingOffer();
        Integer[][] special = new Integer[][]{{1, 1, 0, 4}, {2, 2, 1, 9}};
        List<List<Integer>> specials = Arrays.stream(special)
                .map(Arrays::asList)
                .collect(Collectors.toList());
        Arrays.asList(special);
        int res = shoppingOffer.shoppingOffers(Arrays.asList(2, 3, 4), specials, Arrays.asList(1, 2, 1));
        System.out.println(res);
    }

}
