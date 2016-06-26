package com.wang.ssm.dao.mapper;

import com.wang.ssm.po.Xsb;
import com.wang.ssm.po.XsbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XsbMapper {
    int countByExample(XsbExample example);

    int deleteByExample(XsbExample example);

    int insert(Xsb record);

    int insertSelective(Xsb record);

    List<Xsb> selectByExampleWithBLOBs(XsbExample example);

    List<Xsb> selectByExample(XsbExample example);

    int updateByExampleSelective(@Param("record") Xsb record, @Param("example") XsbExample example);

    int updateByExampleWithBLOBs(@Param("record") Xsb record, @Param("example") XsbExample example);

    int updateByExample(@Param("record") Xsb record, @Param("example") XsbExample example);
}