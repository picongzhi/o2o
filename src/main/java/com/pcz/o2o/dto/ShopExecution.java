package com.pcz.o2o.dto;

import com.pcz.o2o.entity.Shop;
import com.pcz.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * @author picongzhi
 */
public class ShopExecution {
    /**
     * 结果状态
     */
    private int state;

    /**
     * 状态标识
     */
    private String stateInfo;

    /**
     * 店铺数量
     */
    private int count;

    /**
     * 操作的店铺
     */
    private Shop shop;

    /**
     * shop列表
     */
    private List<Shop> shopList;

    public ShopExecution() {
    }

    public ShopExecution(ShopStateEnum state) {
        this.state = state.getState();
        this.stateInfo = state.getStateInfo();
    }

    public ShopExecution(ShopStateEnum state, Shop shop) {
        this.state = state.getState();
        this.stateInfo = state.getStateInfo();
        this.shop = shop;
    }

    public ShopExecution(ShopStateEnum state, List<Shop> shopList) {
        this.state = state.getState();
        this.stateInfo = state.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
