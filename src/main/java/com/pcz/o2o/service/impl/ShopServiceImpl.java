package com.pcz.o2o.service.impl;

import com.pcz.o2o.dao.ShopMapper;
import com.pcz.o2o.dto.ShopExecution;
import com.pcz.o2o.entity.Shop;
import com.pcz.o2o.enums.ShopStateEnum;
import com.pcz.o2o.exceptions.ShopOperationException;
import com.pcz.o2o.service.ShopService;
import com.pcz.o2o.util.ImageUtil;
import com.pcz.o2o.util.PathUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * @author picongzhi
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Transactional
    @Override
    public ShopExecution addShop(Shop shop, InputStream inputStream, String fileName) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }

        try {
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            int rows = shopMapper.insertShop(shop);

            if (rows <= 0) {
                throw new ShopOperationException("店铺创建失败");
            }

            if (inputStream != null) {
                addShopImg(shop, inputStream, fileName);
                if (StringUtils.isBlank(shop.getShopImg())) {
                    throw new ShopOperationException("add shop img error");
                }

                rows = shopMapper.updateShop(shop);
                if (rows <= 0) {
                    throw new ShopOperationException("更新图片地址失败");
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("add shop error: " + e.getMessage());
        }

        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, InputStream inputStream, String fileName) {
        String destination = PathUtil.getShopImagePath(String.valueOf(shop.getShopId()));
        String shopImgAddr = ImageUtil.generateThumbnail(inputStream, fileName, destination);
        shop.setShopImg(shopImgAddr);
    }

    @Override
    public Shop getByShopId(long shopId) {
        return shopMapper.queryByShopId(shopId);
    }

    @Transactional
    @Override
    public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }

        try {
            if (shopImgInputStream != null) {
                Shop shopBean = shopMapper.queryByShopId(shop.getShopId());
                if (StringUtils.isNotBlank(shopBean.getShopImg())) {
                    ImageUtil.deleteFileOrPath(shopBean.getShopImg());
                }

                addShopImg(shop, shopImgInputStream, fileName);
            }

            shop.setLastEditTime(new Date());
            int rows = shopMapper.updateShop(shop);
            if (rows <= 0) {
                return new ShopExecution(ShopStateEnum.INNER_ERROR);
            } else {
                shop = shopMapper.queryByShopId(shop.getShopId());
                return new ShopExecution(ShopStateEnum.SUCCESS, shop);
            }
        } catch (Exception e) {
            throw new ShopOperationException("modifyShop error: " + e.getMessage());
        }
    }
}
