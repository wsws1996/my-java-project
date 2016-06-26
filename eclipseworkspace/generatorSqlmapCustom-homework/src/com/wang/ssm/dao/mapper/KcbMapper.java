package com.wang.ssm.dao.mapper;

import com.wang.ssm.po.Kcb;
import com.wang.ssm.po.KcbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KcbMapper {
    int countByExample(KcbExample example);

    int deleteByExample(KcbExample example);

    int insert(Kcb record);

    int insertSelective(Kcb record);

    List<Kcb> selectByExample(KcbExample example);

    int updateByExampleSelective(@Param("record") Kcb record, @Param("example") KcbExample example);

    int updateByExample(@Param("record") Kcb record, @Param("example") KcbExample example);
}