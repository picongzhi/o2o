package com.pcz.o2o.service;

import com.pcz.o2o.BaseTest;
import com.pcz.o2o.dto.ShopExecution;
import com.pcz.o2o.entity.Area;
import com.pcz.o2o.entity.PersonInfo;
import com.pcz.o2o.entity.Shop;
import com.pcz.o2o.entity.ShopCategory;
import com.pcz.o2o.enums.ShopStateEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void addShopTest() throws Exception {
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
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File shopImg = new File("/Users/picongzhi/workspace/java/idea/o2o/src/main/resources/cat.jpeg");
        InputStream inputStream = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.addShop(shop, inputStream, shopImg.getName());
        Assert.assertEquals(ShopStateEnum.CHECK.getState(), shopExecution.getState());

        inputStream.close();
    }

    @Test
    public void modifyShopTest() throws Exception {
        File shopImg = new File("/Users/picongzhi/workspace/java/idea/o2o/src/main/resources/cheer.jpeg");
        InputStream inputStream = new FileInputStream(shopImg);
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("cheer");
        ShopExecution shopExecution = shopService.modifyShop(shop, inputStream, shopImg.getName());
        Assert.assertNotNull(shopExecution);
    }

    @Test
    public void getShopListTest() {
        Shop shopCondition = new Shop();
        shopCondition.setShopName("测试");
        ShopExecution shopExecution = shopService.getShopList(shopCondition, 1, 5);
        Assert.assertNotNull(shopExecution);
    }
}
