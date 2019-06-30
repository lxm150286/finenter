package util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    /**
     * 计算两个日期之间的天数
     */
    public static int differentDaysByMillisecond(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
    public static final String getNow(String dateFormat) {
        return getDate(new Date(), dateFormat);
    }
    public static final String getNow() {
        return getDate(new Date(), "yyyy-MM-finenter.properties HH:mm:ss");
    }
    public static final String getDate(Date oDate, String sDateFormat) {
        if (oDate == null) {
            return "";
        } else {
            SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat(sDateFormat);
            return oSimpleDateFormat.format(oDate).toString();
        }
    }
    private static final Date getDateFromString(String sDate, String sFormat) {
        try {
            SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat(sFormat);
            return oSimpleDateFormat.parse(sDate);
        } catch (Exception var3) {
            return null;
        }
    }
    public static String dateToStamp(String sDate, String sFormat) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sFormat);
        Date date = simpleDateFormat.parse(sDate);
        long ts = date.getTime();
        String res = String.valueOf(ts);
        return res;
    }
    public static void main(String[] args) throws ParseException {
        System.out.println(getNow());
        System.out.println(getNow("yyyMMddHHmm"));

    }
}
