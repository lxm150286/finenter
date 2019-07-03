package javaBean;

/**
 * @Classname SalesInvoiceVO
 * @Description 销售发货单对象信息
 * @Date 2019/7/3 10:26
 * @Created by:lixiaoming1
 */
public class SalesInvoiceVO {
    private String order_type;
    private String  order_no;
    private String shipping_date;
    private String customer_code;
    private String  customer_name;
    private String   currency;
    private String sales_company_code;
    private String source_document;
    private String source_order_no;
    /**
     * 单据状态
     */
    private int order_status;
    /**
     * 发货数量
     */
    private int shipping_quantity;
    private String data_source;
    private String  shipping_method;
    private String shipping_channel;
    private String waybill_number;
    private String ec_order_no;
    /**
     * 删除标识
     */
    private int  del_flag;
    private String create_by;
    private int create_by_id;
    private String  update_by;
    private int update_by_id;
    private String create_time;
    private String update_time;

    public String getSalesData(){
        return "('"+order_type+"','"+order_no+"','"+shipping_date+"',"+order_status+",'"+data_source+"');";
    }
    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getShipping_date() {
        return shipping_date;
    }

    public void setShipping_date(String shipping_date) {
        this.shipping_date = shipping_date;
    }

    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSales_company_code() {
        return sales_company_code;
    }

    public void setSales_company_code(String sales_company_code) {
        this.sales_company_code = sales_company_code;
    }

    public String getSource_document() {
        return source_document;
    }

    public void setSource_document(String source_document) {
        this.source_document = source_document;
    }

    public String getSource_order_no() {
        return source_order_no;
    }

    public void setSource_order_no(String source_order_no) {
        this.source_order_no = source_order_no;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }

    public int getShipping_quantity() {
        return shipping_quantity;
    }

    public void setShipping_quantity(int shipping_quantity) {
        this.shipping_quantity = shipping_quantity;
    }

    public String getData_source() {
        return data_source;
    }

    public void setData_source(String data_source) {
        this.data_source = data_source;
    }

    public String getShipping_method() {
        return shipping_method;
    }

    public void setShipping_method(String shipping_method) {
        this.shipping_method = shipping_method;
    }

    public String getShipping_channel() {
        return shipping_channel;
    }

    public void setShipping_channel(String shipping_channel) {
        this.shipping_channel = shipping_channel;
    }

    public String getWaybill_number() {
        return waybill_number;
    }

    public void setWaybill_number(String waybill_number) {
        this.waybill_number = waybill_number;
    }

    public String getEc_order_no() {
        return ec_order_no;
    }

    public void setEc_order_no(String ec_order_no) {
        this.ec_order_no = ec_order_no;
    }

    public int getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public int getCreate_by_id() {
        return create_by_id;
    }

    public void setCreate_by_id(int create_by_id) {
        this.create_by_id = create_by_id;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public int getUpdate_by_id() {
        return update_by_id;
    }

    public void setUpdate_by_id(int update_by_id) {
        this.update_by_id = update_by_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "SalesInvoiceVO{" +
                "order_type='" + order_type + '\'' +
                ", order_no='" + order_no + '\'' +
                ", shipping_date='" + shipping_date + '\'' +
                ", customer_code='" + customer_code + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", currency='" + currency + '\'' +
                ", sales_company_code='" + sales_company_code + '\'' +
                ", source_document='" + source_document + '\'' +
                ", source_order_no='" + source_order_no + '\'' +
                ", order_status=" + order_status +
                ", shipping_quantity=" + shipping_quantity +
                ", data_source='" + data_source + '\'' +
                ", shipping_method='" + shipping_method + '\'' +
                ", shipping_channel='" + shipping_channel + '\'' +
                ", waybill_number='" + waybill_number + '\'' +
                ", ec_order_no='" + ec_order_no + '\'' +
                ", del_flag=" + del_flag +
                ", create_by='" + create_by + '\'' +
                ", create_by_id=" + create_by_id +
                ", update_by='" + update_by + '\'' +
                ", update_by_id=" + update_by_id +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
