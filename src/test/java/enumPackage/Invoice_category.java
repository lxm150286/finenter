package enumPackage;

/**
 * 发票类别
 */
public enum Invoice_category {
    // 蓝字发票
    BLUE_WORD_INVOICE("blue_word_invoice"),

    // 红字发票
    RED_WORD_INVOICE("red_word_invoice");
    private String value;
    Invoice_category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
