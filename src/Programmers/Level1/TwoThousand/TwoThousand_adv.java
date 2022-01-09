package Programmers.Level1.TwoThousand;
import java.text.SimpleDateFormat;
import java.util.*;


public class TwoThousand_adv {
    public String getDagName(int month, int day){
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601").setDate(2016, month - 1, day).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }

}
