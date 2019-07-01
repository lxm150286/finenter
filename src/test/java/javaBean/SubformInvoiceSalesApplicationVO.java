package javaBean;

import java.util.List;

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
        private int  order_type;

        @Override
        public String toString() {
            return "SubformInvoiceSalesApplication{" +
                    "application_no='" + application_no + '\'' +
                    ", shop_order_id='" + shop_order_id + '\'' +
                    ", ec_order_no='" + ec_order_no + '\'' +
                    ", order_type=" + order_type +
                    ", del_flag=" + del_flag +
                    '}';
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

        public int getOrder_type() {
            return order_type;
        }

        public void setOrder_type(int order_type) {
            this.order_type = order_type;
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