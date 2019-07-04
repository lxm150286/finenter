package helper;

import static util.DataUtil.getNow;

public class DataProvider {

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
//随机得到三位数的正整数
    public static String getThreeNumber() {
        String number =String.valueOf(getNum(1, 10000) + 10000).substring(1);;
        return number;
    }
    /**
     * 生成开票申请单号：KP2019050712140001
     */
    public static String getInvoiceApplicationNumber(){
        return "KP"+getNow("yyyMMddHHmm")+getThreeNumber()+getThreeNumber();
    }

    /**
     * 生成发货订单编号:145635906798033
     * @param
     */
    public static String getOrderNO(){
        return "14563590679"+getThreeNumber();
    }

    /**
     * 生成EC订单编号39514563590679803
     * @return
     */
    public static String getECOrderNumber(){
        return "EC"+getThreeNumber()+getThreeNumber()+getThreeNumber();
    };
    public static void main(String[] args) {
       System.out.println(getOrderNO());
    }
}
