package com.pcz.o2o.dao;

import com.pcz.o2o.entity.Area;

import java.util.List;

/**
 * @author picongzhi
 */
public interface AreaMapper {
    /**
     * 列出区域列表
     *
     * @return List<Area>
     */
    List<Area> queryArea();
}
