package interview.amazon.onsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ychang on 4/4/2017.
 */
public class BestSeller {
  private TreeMap<Integer, List<Integer>> rankingList;
  private Map<Integer, SellItemProxy> prodMap;

  public BestSeller() {
    rankingList = new TreeMap<>();
    prodMap = new HashMap<>();
  }

  public List<Integer> getBestSeller(int num) {
    List<Integer> res = new ArrayList<>();
    for (Integer amount : rankingList.descendingKeySet()) {
      res.addAll(rankingList.get(amount));
      if (res.size()>num) return res;
    }
    return res;
  }

  public void addNewSoldItem(int prodId, int amount){
    if (prodMap.containsKey(prodId)) {
      Integer oldAmount = prodMap.get(prodId).soldAmount;
      rankingList.get(oldAmount).remove(new Integer(prodId));
      prodMap.get(prodId).soldAmount+=amount;
    } else {
      SellItemProxy sellItemProxy = new SellItemProxy(prodId, amount);
      prodMap.put(prodId, sellItemProxy);
    }
    int rankKey = prodMap.get(prodId).soldAmount;
    rankingList.computeIfAbsent(rankKey, k -> new ArrayList()).add(prodId);
  }
}

class SellItemProxy {
  Integer prodId;
  Integer soldAmount;

  public SellItemProxy(Integer prodId, Integer soldAmount) {
    this.prodId = prodId;
    this.soldAmount = soldAmount;
  }
}