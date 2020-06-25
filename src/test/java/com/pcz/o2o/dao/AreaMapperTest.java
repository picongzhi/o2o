package com.pcz.o2o.dao;

import com.pcz.o2o.BaseTest;
import com.pcz.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AreaMapperTest extends BaseTest {
    @Autowired
    private AreaMapper areaMapper;

    @Test
    public void queryAreaTest() {
        List<Area> areaList = areaMapper.queryArea();
        Assert.assertEquals(2, areaList.size());
    }
}
