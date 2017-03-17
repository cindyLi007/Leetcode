package com.google.hash.table;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ychang on 12/9/2016.
 */
public class UniqueWord {
  Map<String, String> map;

  public UniqueWord(String[] dictionary) {
    map = new HashMap();
    for (String word : dictionary) {
      int len = word.length();
      String key = len<=2 ? word : word.charAt(0) + String.valueOf(len - 2) + word.charAt(len - 1);
      /**
       * If there is more than one string belong to the same key, then the key will be invalid, we set the value to ""
       * so if get(key) is not "", we can guarantee there is only one word in the dictionary related to that Abbr
       */
      if (map.containsKey(key) && !map.get(key).equals(word))
        map.put(key, "");
      else
        map.put(key, word);
    }
  }

  public boolean isUnique(String word) {
    int len = word.length();
    /*
      try to avoid use (len-2)+"", use String.valueOf(len-2) to guarantee it will be convert to a String
     */
    String key = len<=2 ? word : word.charAt(0) + String.valueOf(len - 2) + word.charAt(len - 1);
    return !map.containsKey(key) || map.get(key).equals(word);
  }

  public static void main(String[] args) {
    String[] dic = new String[]{"uddgk", "ctlttczn", "sttgxmclaie", "ntbbaimu", "icfvfjvrhwhbtgx", "kqrhgnvkio", "jqlitvcpiicqpfkawdw", "ashmwctihjqhuiy", "zif", "yicc", "cptyqzqljicqfwt", "ckuxszpswyo", "ywfhpzfoytgarz", "uxf", "vgtzabhgqujfaokg", "xvkaerg", "nlpmjqfdkpcs", "uvl", "yvyizeb", "bcpf", "mtglddpaeibiifmmunb", "qha", "qawfqkwo", "qctmkbww", "hfsvzaiigde", "jxlpqpuavgsbhkikkq", "itazmzscfqkgiehvoeb", "nvwedfkgtjndiu", "uxbyakwxj", "xxqs", "xzrrolxr", "kuz", "socdiwwisakbrcooagci", "anqortwnsjrfqxgegit", "ohwhworduzv", "dbb", "klmtiriqop", "dcflvnkpyyrmyofi", "znfkqvfjlixniv", "pithtwzlbiumn", "yjzuwb", "kpbwptujiodaxpwdlu", "yvwqwolp", "exhynddnabktgeupy", "jpavodjjhphygyawq", "yuq", "btcbnjdpwghidfsf", "ltj", "inqreztqhgdo", "cunvxsxbnqsbcdktn", "dvoufrm", "nqqxgdv", "dhzpwmekdeffe", "elophkpyoqzqyravpt", "elkqhirmljlye", "zunpatmz", "lvjns", "coinatoywzmoijuvemc", "oxkyazafozivsclge", "cvoxvhimxizqcr", "cgnmgslzp", "hcynpbbudvbtyh", "piptkaghjlpohodh", "fozrpmoe", "djowrixhenoseb", "pffilvhhxxhvbw", "eyygrsqire", "wfso", "tofgawoeye", "zrkzcxvrbekd", "uvexlqvmcafpxta", "delyx", "nryl", "brcvudbrfalilkeqxabc", "vpqwcdtquuvfre", "hjaydqkimr", "dmkpjbovhpqbgshnvywm", "lqkmuwpfksu", "chen", "ifimk", "cyreurnf", "wbajhkmney", "aqf", "xuxssbg", "mffecsqvjwxk", "lvrujzf", "qcmeev", "btzaifzdorsl", "eisxunmgyx", "vmyplrtzqwutzvybbz", "mjreyibaouoc", "xufpespcuoxbecjn", "uqecpqsazfz", "hpzgzlmkzrsggrpzqd", "wnrpgrhhchlmxatwxhms", "pchyxjipfcyf", "vgfpkxnldvfambqibg", "eilqpsglhumyyoxguvz", "itziizbrarrt", "iqrezhpcw", "dlfgmyk", "dmnbu", "jxfgagxr", "dpncywtcqt", "lcgw", "nlsldnwumdibpra", "npbeifowvxr", "ehfdqxwbwwl", "xfdbax", "axrg", "pckoadjgub", "kzsllndsmracvhcqxi", "imjo", "jgbgwxnwhbxjukznm", "tvehln", "uhhtmqztymuqenbsejt", "jlirbrwpnexysmhii", "zwibguufkgm", "vthotnijfovkxnkfl", "aityurlipkowcdhvej", "mitzlrwaua", "thkcxeyyjwwouzcm", "jfehjpzlyplijmd", "ajbtzwwfcnhuaks", "eholqtanbznfbqygoetn", "lnszbftih", "ocserqjx", "rzbscicsezuzvmhwlr"};
    UniqueWord uniqueWord = new UniqueWord(dic);
    System.out.println(uniqueWord.isUnique("dear")); // false
    System.out.println(uniqueWord.isUnique("cart")); // true
    System.out.println(uniqueWord.isUnique("cane")); // false
    System.out.println(uniqueWord.isUnique("make")); // true
  }
}
