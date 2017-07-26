package temp;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by ychang on 6/15/2017.
 */
public class PrintDate {

  public static void main(String[] args) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY MMM dd");
    Calendar calendar = new GregorianCalendar(2017, 1, 16);
    int count=0;
    for (int y = 2017; y<=2027; y++) {
      for (int m = 0; m<12; m++) {
        calendar.set(Calendar.YEAR, y);
        calendar.set(Calendar.MONTH, m);
        if (calendar.get(Calendar.DAY_OF_WEEK)==2) {
          System.out.println("Date : " + simpleDateFormat.format(calendar.getTime()));
          count++;
        }
      }
    }
    System.out.println("Total is " + count);
  }
}
