package com.pcz.o2o.service;

import com.pcz.o2o.dto.ShopExecution;
import com.pcz.o2o.entity.Shop;

import java.io.File;
import java.io.InputStream;

/**
 * @author picongzhi
 */
public interface ShopService {
    /**
     * 注册店铺
     *
     * @param shop
     * @param inputStream
     * @return
     */
    ShopExecution addShop(Shop shop, InputStream inputStream, String fileName);

    /**
     * 根据id获取shop
     *
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
