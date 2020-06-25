package com.pcz.o2o.service;

import com.pcz.o2o.BaseTest;
import com.pcz.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaListTest() {
        List<Area> areaList = areaService.getAreaList();
        Assert.assertEquals(2, areaList.size());
    }
}
