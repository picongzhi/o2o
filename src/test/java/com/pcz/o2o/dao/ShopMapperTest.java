package com.pcz.o2o.dao;

import com.pcz.o2o.BaseTest;
import com.pcz.o2o.entity.Area;
import com.pcz.o2o.entity.PersonInfo;
import com.pcz.o2o.entity.Shop;
import com.pcz.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopMapperTest extends BaseTest {
    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void insertShopTest() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);

        Area area = new Area();
        area.setAreaId(2);

        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);

        Shop shop = new Shop();
        shop.setOwner(personInfo);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int effected = shopMapper.insertShop(shop);
        Assert.assertEquals(1, effected);
    }

    @Test
    public void updateShopTest() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);

        Area area = new Area();
        area.setAreaId(2);

        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);

        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setOwner(personInfo);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopName("测试店铺");
        shop.setShopDesc("test2");
        shop.setShopAddr("test2");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int effected = shopMapper.updateShop(shop);
        Assert.assertEquals(1, effected);
    }
}
