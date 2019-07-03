package javaBean;

import java.util.List;

/**
 * @Classname SalesInvoiceDetailVO
 * @Description TODO
 * @Date 2019/7/3 15:14
 * @Created by:lixiaoming1
 */
public class SalesInvoiceDetailVO {
    private List<SubSalesInvoiceEetailVO> deliverylist;

    public List <SubSalesInvoiceEetailVO> getDeliverylist() {
        return deliverylist;
    }

    public void setDeliverylist(List <SubSalesInvoiceEetailVO> deliverylist) {
        this.deliverylist = deliverylist;
    }

    public static class SubSalesInvoiceEetailVO{
       private String order_no;
       private String material_no;
       private String product_code;
       private String   product_name;
       private int line_no;
       private int gift_flag;
       private int   component_flag;
       private int parent_id;
       private int writeoff_flag;
       private int quantity;
       private int unit;
       private int has_tax;
       private int quotation;
       private int total_amount;
       private int shop_discount;
       private int platform_discount;
       private int payment;
       private int paid_amount;
       private int tax_plan_code;
       private int payment_without_tax23;;
       private int tax;
       private int shipping_cost;
       private int source_document_line;
       private int del_flag;
       private String warehouse_code;
       private String warehouse_name;
       private String source_document;
       private String source_order_no;
       private String shop_order_id;
      public String getSubSalesInvoiceData(){
          return "("+order_no+","+line_no+",'"+product_code+"',"+gift_flag+","+component_flag+","+","+del_flag+");";

      }
       public String getOrder_no() {
           return order_no;
       }

       public void setOrder_no(String order_no) {
           this.order_no = order_no;
       }

       public String getMaterial_no() {
           return material_no;
       }

       public void setMaterial_no(String material_no) {
           this.material_no = material_no;
       }

       public String getProduct_code() {
           return product_code;
       }

       public void setProduct_code(String product_code) {
           this.product_code = product_code;
       }

       public String getProduct_name() {
           return product_name;
       }

       public void setProduct_name(String product_name) {
           this.product_name = product_name;
       }

       public int getLine_no() {
           return line_no;
       }

       public void setLine_no(int line_no) {
           this.line_no = line_no;
       }

       public int getGift_flag() {
           return gift_flag;
       }

       public void setGift_flag(int gift_flag) {
           this.gift_flag = gift_flag;
       }

       public int getComponent_flag() {
           return component_flag;
       }

       public void setComponent_flag(int component_flag) {
           this.component_flag = component_flag;
       }

       public int getParent_id() {
           return parent_id;
       }

       public void setParent_id(int parent_id) {
           this.parent_id = parent_id;
       }

       public int getWriteoff_flag() {
           return writeoff_flag;
       }

       public void setWriteoff_flag(int writeoff_flag) {
           this.writeoff_flag = writeoff_flag;
       }

       public int getQuantity() {
           return quantity;
       }

       public void setQuantity(int quantity) {
           this.quantity = quantity;
       }

       public int getUnit() {
           return unit;
       }

       public void setUnit(int unit) {
           this.unit = unit;
       }

       public int getHas_tax() {
           return has_tax;
       }

       public void setHas_tax(int has_tax) {
           this.has_tax = has_tax;
       }

       public int getQuotation() {
           return quotation;
       }

       public void setQuotation(int quotation) {
           this.quotation = quotation;
       }

       public int getTotal_amount() {
           return total_amount;
       }

       public void setTotal_amount(int total_amount) {
           this.total_amount = total_amount;
       }

       public int getShop_discount() {
           return shop_discount;
       }

       public void setShop_discount(int shop_discount) {
           this.shop_discount = shop_discount;
       }

       public int getPlatform_discount() {
           return platform_discount;
       }

       public void setPlatform_discount(int platform_discount) {
           this.platform_discount = platform_discount;
       }

       public int getPayment() {
           return payment;
       }

       public void setPayment(int payment) {
           this.payment = payment;
       }

       public int getPaid_amount() {
           return paid_amount;
       }

       public void setPaid_amount(int paid_amount) {
           this.paid_amount = paid_amount;
       }

       public int getTax_plan_code() {
           return tax_plan_code;
       }

       public void setTax_plan_code(int tax_plan_code) {
           this.tax_plan_code = tax_plan_code;
       }

       public int getPayment_without_tax23() {
           return payment_without_tax23;
       }

       public void setPayment_without_tax23(int payment_without_tax23) {
           this.payment_without_tax23 = payment_without_tax23;
       }

       public int getTax() {
           return tax;
       }

       public void setTax(int tax) {
           this.tax = tax;
       }

       public int getShipping_cost() {
           return shipping_cost;
       }

       public void setShipping_cost(int shipping_cost) {
           this.shipping_cost = shipping_cost;
       }

       public int getSource_document_line() {
           return source_document_line;
       }

       public void setSource_document_line(int source_document_line) {
           this.source_document_line = source_document_line;
       }

       public int getDel_flag() {
           return del_flag;
       }

       public void setDel_flag(int del_flag) {
           this.del_flag = del_flag;
       }

       public String getWarehouse_code() {
           return warehouse_code;
       }

       public void setWarehouse_code(String warehouse_code) {
           this.warehouse_code = warehouse_code;
       }

       public String getWarehouse_name() {
           return warehouse_name;
       }

       public void setWarehouse_name(String warehouse_name) {
           this.warehouse_name = warehouse_name;
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

       public String getShop_order_id() {
           return shop_order_id;
       }

       public void setShop_order_id(String shop_order_id) {
           this.shop_order_id = shop_order_id;
       }

       @Override
       public String toString() {
           return "SalesInvoiceDetailVO{" +
                   "order_no='" + order_no + '\'' +
                   ", material_no='" + material_no + '\'' +
                   ", product_code='" + product_code + '\'' +
                   ", product_name='" + product_name + '\'' +
                   ", line_no=" + line_no +
                   ", gift_flag=" + gift_flag +
                   ", component_flag=" + component_flag +
                   ", parent_id=" + parent_id +
                   ", writeoff_flag=" + writeoff_flag +
                   ", quantity=" + quantity +
                   ", unit=" + unit +
                   ", has_tax=" + has_tax +
                   ", quotation=" + quotation +
                   ", total_amount=" + total_amount +
                   ", shop_discount=" + shop_discount +
                   ", platform_discount=" + platform_discount +
                   ", payment=" + payment +
                   ", paid_amount=" + paid_amount +
                   ", tax_plan_code=" + tax_plan_code +
                   ", payment_without_tax23=" + payment_without_tax23 +
                   ", tax=" + tax +
                   ", shipping_cost=" + shipping_cost +
                   ", source_document_line=" + source_document_line +
                   ", del_flag=" + del_flag +
                   ", warehouse_code='" + warehouse_code + '\'' +
                   ", warehouse_name='" + warehouse_name + '\'' +
                   ", source_document='" + source_document + '\'' +
                   ", source_order_no='" + source_order_no + '\'' +
                   ", shop_order_id='" + shop_order_id + '\'' +
                   '}';
       }
   }
}
