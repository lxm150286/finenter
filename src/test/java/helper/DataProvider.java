package helper;

import static util.DataUtil.getNow;

public class DataProvider {

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
//随机得到三位数的正整数
    public static String getThreeNumber() {
        String number =String.valueOf(getNum(1, 1000) + 10000).substring(1);;
        return number;
    }
    /**
     * 生成开票申请单号：KP2019050712140001
     */
    public static String getInvoiceApplicationNumber(){
        return "KP"+getNow("yyyMMddHHmm")+getThreeNumber();
    }

    public static void main(String[] args) {
       System.out.println(getInvoiceApplicationNumber());
    }
}
