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
}
