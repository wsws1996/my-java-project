package com.wang.purchasing.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wang.purchasing.po.PurBusOrder;
import com.wang.purchasing.po.PurBusOrderExample;

public interface PurBusOrderMapper {
    int countByExample(PurBusOrderExample example);

    int deleteByExample(PurBusOrderExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurBusOrder record);

    int insertSelective(PurBusOrder record);

    List<PurBusOrder> selectByExampleWithBLOBs(PurBusOrderExample example);

    List<PurBusOrder> selectByExample(PurBusOrderExample example);

    PurBusOrder selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurBusOrder record, @Param("example") PurBusOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") PurBusOrder record, @Param("example") PurBusOrderExample example);

    int updateByExample(@Param("record") PurBusOrder record, @Param("example") PurBusOrderExample example);

    int updateByPrimaryKeySelective(PurBusOrder record);

    int updateByPrimaryKeyWithBLOBs(PurBusOrder record);

    int updateByPrimaryKey(PurBusOrder record);
}