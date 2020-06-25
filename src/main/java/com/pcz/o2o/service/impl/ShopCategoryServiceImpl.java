package com.pcz.o2o.service.impl;

import com.pcz.o2o.dao.ShopCategoryMapper;
import com.pcz.o2o.entity.ShopCategory;
import com.pcz.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author picongzhi
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryMapper shopCategoryMapper;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
        return shopCategoryMapper.queryShopCategory(shopCategory);
    }
}
