package interview.microsoft.onsite;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

/**
 * Created by ychang on 8/21/2017.
 */
public class RemoveDuplicatedCharFromString {
  public String removeDuplicatedCharFromString(String string) {
    Preconditions.checkArgument(StringUtils.isNotBlank(string), "Parameter String could not be empty");

    int i=0, j=1;
    char[] ch = string.toCharArray();
    while (j<ch.length) {
      if (ch[i]!=ch[j]) {
        ch[++i]=ch[j];
      }
      j++;
    }
    /**
     * notice, the last char is i, and the end is i+1 since copyValueOf is exclude end point
     */
    return String.copyValueOf(ch, 0, i+1);
  }
}
