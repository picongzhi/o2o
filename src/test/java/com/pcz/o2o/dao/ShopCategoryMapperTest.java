package com.pcz.o2o.dao;

import com.pcz.o2o.BaseTest;
import com.pcz.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryMapperTest extends BaseTest {
    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Test
    public void queryShopCategoryTest() {
        List<ShopCategory> shopCategories = shopCategoryMapper.queryShopCategory(new ShopCategory());
        Assert.assertEquals(2, shopCategories.size());
    }
}
