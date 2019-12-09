package com.rl.mes.pojo;

/**
 */
public class PickData {

    private static final long serialVersionUID = 1L;

    /**
     * 类型
     */
    String type;
    /**
     * 条码
     */
    String barcode;
    /**
     * 汇总数量
     */
    Integer qty;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
