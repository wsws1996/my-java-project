package com.wang.purchasing.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wang.purchasing.po.PurBusOrderAudit;
import com.wang.purchasing.po.PurBusOrderAuditExample;

public interface PurBusOrderAuditMapper {
    int countByExample(PurBusOrderAuditExample example);

    int deleteByExample(PurBusOrderAuditExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurBusOrderAudit record);

    int insertSelective(PurBusOrderAudit record);

    List<PurBusOrderAudit> selectByExample(PurBusOrderAuditExample example);

    PurBusOrderAudit selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurBusOrderAudit record, @Param("example") PurBusOrderAuditExample example);

    int updateByExample(@Param("record") PurBusOrderAudit record, @Param("example") PurBusOrderAuditExample example);

    int updateByPrimaryKeySelective(PurBusOrderAudit record);

    int updateByPrimaryKey(PurBusOrderAudit record);
}