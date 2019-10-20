package interview.microsoft.onsite;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Preconditions;

/**
 * Created by ychang on 8/21/2017.
 */
public class LetterCombination {
  final String[] LETTERS = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombination(String digits) {
    Preconditions.checkArgument(isNotEmpty(digits) && digits.length()==10,
        "Please enter a valid 10 digit phone number");

    char[] numbers = digits.substring(3, 10).toCharArray();
    List<String> res = new LinkedList<>();

    dfs(numbers, 0, digits.substring(0, 3) + " ", res);
    return res;
  }

  private void dfs(char[] numbers, int index, String prefix, List<String> res) {
    if (index==numbers.length) {
      res.add(prefix);
    } else {
      char[] chars = LETTERS[numbers[index] - '0'].toCharArray();
      for (char c : chars) {
        dfs(numbers, index + 1, prefix + c, res);
      }
    }
  }
}
