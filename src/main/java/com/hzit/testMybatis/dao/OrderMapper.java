package com.hzit.testMybatis.dao;

import com.hzit.testMybatis.model.Orders;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    /**
     * 查询订单
     * @param id
     */
    public Orders queryOrderById(@Param("id") Integer id);
}
