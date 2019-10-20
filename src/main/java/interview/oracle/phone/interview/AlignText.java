package interview.oracle.phone.interview;

/*
 Question: Pad the string such that spaces between words are equally distributed to match the padLength and if there are
 extra spaces, start adding the spaces from first word to last word.

Input:
string:"I am fine"
padLength: 11
Output:”I<Space><Space>am<Space><Space>fine”

Input:
string:"I am fine"
padLength: 10
Output:”I<Space><Space>am<Space>fine”

lI am fine, length is 5 ,
Iamfine
*/

public class AlignText {
  public static void main(String[] args) {
    System.out.println(padLength(" Grace  IsHere ", 15));
    System.out.println(padLength(" I am   fine ", 15));
    System.out.println(padLength("I am fine ", 10));
  }

  // Time: O(N) N is # of char
  // Space: O(N) N is # of char since we used a String[]
  public static String padLength(String words, int length) {
    if (words==null || words.length()==0) return "";
    words = words.trim(); // any leading and trailing whitespace removed
    String[] wordArray = words.split("\\s+");
    int M = wordArray.length, N = words.replaceAll("\\s+", "").length();

    if (M==1) return words;
    int k = (length - N)/(M-1), mod = (length-N) % (M-1);
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<M; i++) {
      sb.append(wordArray[i]);
      for (int j=0; j<k && i<M-1; j++) {
        sb.append(".");
      }
      if (mod-->0) sb.append(".");
    }

    return sb.toString();
  }
}

