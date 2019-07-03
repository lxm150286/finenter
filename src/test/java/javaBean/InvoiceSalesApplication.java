package javaBean;
/**
 * @Classname InvoiceSalesApplication
 * @Description 封装获取开票申请主表信息对象
 * @Date 2019/7/1 9:30
 * @Created by:lixiaoming1
 */
public class InvoiceSalesApplication {
    /**
     * 开票申请的状态
     */
    private int status;
    /**
     *客服备注
     */
    private String customer_service_note;
    /**
     *开票申请单号
     */
    private String  application_no;
    /**
     *发票类型
     */
    private int invoice_type;
    /**
     *invoice_category
     */
    private String  invoice_category;
    /**
     *店铺编号
     */
    private int  shop_code;
    /**
     *店铺订单编号
     */
    private String  shop_order_id;
    /**
     *EC订单编号
     */
    private String ec_order_no;
    /**
     *发票抬头
     */
    private String  invoice_info;
    /**
     * 纳税人识别号
     */
    private String   taxpayer_id_no;
    /**
     * 购买方开户行
     */
    private String  purchaser_bank;
    /**
     * 购买方开户行帐号
     */
    private String bank_account;
    /**
     * 购买方电话
     */
    private String  purchaser_phone;
   /**
   * 购买方地址
   */
   private String purchaser_area;
    /**
     * 发票备注
     */
    private String invoice_remark;
    /**
     * 收票人
     */
    private String receiver ;
    /**
     *  删除标识
     */
    private int del_flag;
    /**
     * 店铺简称
     */
    private String  hop_short_name ;
    /**
     * 订单状态
     */
    private int order_status;
    public String getData(){
        return "("+status+",'"+customer_service_note+"','"+application_no+"',"+invoice_type+",'"+invoice_category+"',"+shop_code+",'"+shop_order_id+"','"+ec_order_no+"',"+order_status+","+del_flag+");";
    }
    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
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

    public String getTaxpayer_id_no() {
        return taxpayer_id_no;
    }

    public void setTaxpayer_id_no(String taxpayer_id_no) {
        this.taxpayer_id_no = taxpayer_id_no;
    }

    public String getPurchaser_bank() {
        return purchaser_bank;
    }

    public void setPurchaser_bank(String purchaser_bank) {
        this.purchaser_bank = purchaser_bank;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public String getPurchaser_phone() {
        return purchaser_phone;
    }

    public void setPurchaser_phone(String purchaser_phone) {
        this.purchaser_phone = purchaser_phone;
    }

    public String getPurchaser_area() {
        return purchaser_area;
    }

    public void setPurchaser_area(String purchaser_area) {
        this.purchaser_area = purchaser_area;
    }

    public String getInvoice_remark() {
        return invoice_remark;
    }

    public void setInvoice_remark(String invoice_remark) {
        this.invoice_remark = invoice_remark;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(int del_flag) {
        this.del_flag = del_flag;
    }

    public String getHop_short_name() {
        return hop_short_name;
    }

    public void setHop_short_name(String hop_short_name) {
        this.hop_short_name = hop_short_name;
    }

    @Override
    public String toString() {
        return "InvoiceSalesApplication{" +
                "status=" + status +
                ", customer_service_note='" + customer_service_note + '\'' +
                ", application_no='" + application_no + '\'' +
                ", invoice_type=" + invoice_type +
                ", invoice_category='" + invoice_category + '\'' +
                ", shop_code=" + shop_code +
                ", shop_order_id='" + shop_order_id + '\'' +
                ", ec_order_no='" + ec_order_no + '\'' +
                ", invoice_info='" + invoice_info + '\'' +
                ", taxpayer_id_no='" + taxpayer_id_no + '\'' +
                ", purchaser_bank='" + purchaser_bank + '\'' +
                ", bank_account='" + bank_account + '\'' +
                ", purchaser_phone='" + purchaser_phone + '\'' +
                ", purchaser_area='" + purchaser_area + '\'' +
                ", invoice_remark='" + invoice_remark + '\'' +
                ", receiver='" + receiver + '\'' +
                ", del_flag=" + del_flag +
                ", hop_short_name='" + hop_short_name + '\'' +
                '}';
    }

}
