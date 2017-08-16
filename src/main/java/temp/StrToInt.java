package temp;

/**
 * Created by ychang on 8/14/2017.
 */
public class StrToInt {
  public int myAtoi(String str) {
    int res=0;
    if (str==null || str.length()==0) return res;
    char[] ch = str.trim().toCharArray();
    int neg=1, i=0;
    if (ch[0]=='+' || ch[0]=='-') {
      i++;
      neg=ch[0]=='-' ? -1 : 1;
    }
    for (; i<ch.length; i++) {
      if (ch[i]<'0' || ch[0]>'9') return res*neg;
      int dig=ch[i]-'0';
      if (res>(Integer.MAX_VALUE-dig)/10) {
        if (neg==1) return Integer.MAX_VALUE;
        return Integer.MIN_VALUE;
      }
      res=res*10+dig;
    }
    return res*neg;
  }

  public static void main(String[] args) {
    StrToInt st = new StrToInt();
    int i = st.myAtoi("  -0012a42");
  }
}
