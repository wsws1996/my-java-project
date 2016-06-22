package com.wang.purchasing.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wang.purchasing.po.PurSysRole;
import com.wang.purchasing.po.PurSysRoleExample;

public interface PurSysRoleMapper {
    int countByExample(PurSysRoleExample example);

    int deleteByExample(PurSysRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurSysRole record);

    int insertSelective(PurSysRole record);

    List<PurSysRole> selectByExample(PurSysRoleExample example);

    PurSysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurSysRole record, @Param("example") PurSysRoleExample example);

    int updateByExample(@Param("record") PurSysRole record, @Param("example") PurSysRoleExample example);

    int updateByPrimaryKeySelective(PurSysRole record);

    int updateByPrimaryKey(PurSysRole record);
}