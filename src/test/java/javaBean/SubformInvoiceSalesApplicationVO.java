package javaBean;

import java.util.List;
/**
 * @Classname SubformInvoiceSalesApplicationVO
 * @Description 封装获取开票申请子表的信息对象
 * @Date 2019/7/1 10:04
 * @Created by:lixiaoming1
 */
public class SubformInvoiceSalesApplicationVO {
    private List<SubformInvoiceSalesApplication> application;

    public List <SubformInvoiceSalesApplication> getApplication() {
        return application;
    }

    public void setApplication(List <SubformInvoiceSalesApplication> application) {
        this.application = application;
    }

    @Override
    public String toString() {
        return "SubformInvoiceSalesApplicationVO{" +
                "application=" + application +
                '}';
    }

    public static class SubformInvoiceSalesApplication {
        private String application_no;
        private String shop_order_id;
        private String ec_order_no;
        private int  order_status;

        @Override
        public String toString() {
            return "SubformInvoiceSalesApplication{" +
                    "application_no='" + application_no + '\'' +
                    ", shop_order_id='" + shop_order_id + '\'' +
                    ", ec_order_no='" + ec_order_no + '\'' +
                    ", order_status=" + order_status +
                    ", del_flag=" + del_flag +
                    '}';
        }
        public String getSubformData(){
            return "('"+application_no+"','"+shop_order_id+"','"+ec_order_no+"',"+order_status+","+del_flag+")";
        }

        public String getApplication_no() {
            return application_no;
        }

        public void setApplication_no(String application_no) {
            this.application_no = application_no;
        }

        public String getShop_order_id() {
            return shop_order_id;
        }

        public void setShop_order_id(String shop_order_id) {
            this.shop_order_id = shop_order_id;
        }

        public String getEc_order_no() {
            return ec_order_no;
        }

        public void setEc_order_no(String ec_order_no) {
            this.ec_order_no = ec_order_no;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public int getDel_flag() {
            return del_flag;
        }

        public void setDel_flag(int del_flag) {
            this.del_flag = del_flag;
        }

        private  int del_flag;

    }
}
