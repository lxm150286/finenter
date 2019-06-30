package javaBean;

public class InvoiceSalesApplication {
    private int status;
    private String customer_service_note;
    private String  application_no;
    private int invoice_type;
    private String  invoice_category;
    private int  shop_code;
    private String  shop_order_id;
    private String ec_order_no;
    private String  invoice_info;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustomer_service_note() {
        return customer_service_note;
    }

    public void setCustomer_service_note(String customer_service_note) {
        this.customer_service_note = customer_service_note;
    }

    public String getApplication_no() {
        return application_no;
    }

    public void setApplication_no(String application_no) {
        this.application_no = application_no;
    }

    public int getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(int invoice_type) {
        this.invoice_type = invoice_type;
    }

    public String getInvoice_category() {
        return invoice_category;
    }

    public void setInvoice_category(String invoice_category) {
        this.invoice_category = invoice_category;
    }

    public int getShop_code() {
        return shop_code;
    }

    public void setShop_code(int shop_code) {
        this.shop_code = shop_code;
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

    public String getInvoice_info() {
        return invoice_info;
    }

    public void setInvoice_info(String invoice_info) {
        this.invoice_info = invoice_info;
    }

}
