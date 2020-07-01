package com.pcz.o2o.dao;

import com.pcz.o2o.entity.Shop;

/**
 * @author picongzhi
 */
public interface ShopMapper {
    /**
     * 新增店铺
     *
     * @param shop Shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     *
     * @param shop Shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 根据shop id查询店铺
     *
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);
}
