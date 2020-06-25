package com.pcz.o2o.enums;

/**
 * @author picongzhi
 */
public enum ShopStateEnum {
    /**
     * 审核中
     */
    CHECK(0, "审核中"),
    /**
     * 非法店铺
     */
    OFFLINE(-1, "非法店铺"),
    /**
     * 操作成功
     */
    SUCCESS(1, "操作成功"),
    /**
     * 通过认证
     */
    PASS(2, "通过认证"),
    /**
     * 内部系统错误
     */
    INNER_ERROR(-1001, "内部系统错误"),
    /**
     * 店铺id为空
     */
    NULL_SHOP_ID(-1002, "店铺id为空"),
    /**
     * 店铺信息为空
     */
    NULL_SHOP(-1003, "店铺信息为空");

    private int state;
    private String stateInfo;

    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static ShopStateEnum stateOf(int state) {
        switch (state) {
            case 0:
                return CHECK;
            case -1:
                return OFFLINE;
            case 1:
                return SUCCESS;
            case 2:
                return PASS;
            case -1001:
                return INNER_ERROR;
            case -1002:
                return NULL_SHOP_ID;
            case -1003:
                return NULL_SHOP;
            default:
                return null;
        }
    }
}
