package com.pcz.o2o.dao;

import com.pcz.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author picongzhi
 */
public interface ShopCategoryMapper {
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategory);
}
