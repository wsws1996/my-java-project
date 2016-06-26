package com.wang.ssm.dao.mapper;

import com.wang.ssm.po.Cjb;
import com.wang.ssm.po.CjbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CjbMapper {
    int countByExample(CjbExample example);

    int deleteByExample(CjbExample example);

    int insert(Cjb record);

    int insertSelective(Cjb record);

    List<Cjb> selectByExample(CjbExample example);

    int updateByExampleSelective(@Param("record") Cjb record, @Param("example") CjbExample example);

    int updateByExample(@Param("record") Cjb record, @Param("example") CjbExample example);
}