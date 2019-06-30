package enumPackage;

public enum getStatus{
    /**
     * 0:待处理
     */
    toBeProcessed("0"),
    /**
     * 2:已处理
     */
    Processed("2"),
    /**
     * 3:处理失败'
     */
    handlingFailure("3"),

    /**
     * 1:已退回
     */
    Returned("1");

    private String value;
    getStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(getStatus.toBeProcessed.getValue());
    }
}
