package com.wang.purchasing.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.wang.purchasing.po.PurSysUserRole;
import com.wang.purchasing.po.PurSysUserRoleExample;

public interface PurSysUserRoleMapper {
    int countByExample(PurSysUserRoleExample example);

    int deleteByExample(PurSysUserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(PurSysUserRole record);

    int insertSelective(PurSysUserRole record);

    List<PurSysUserRole> selectByExample(PurSysUserRoleExample example);

    PurSysUserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PurSysUserRole record, @Param("example") PurSysUserRoleExample example);

    int updateByExample(@Param("record") PurSysUserRole record, @Param("example") PurSysUserRoleExample example);

    int updateByPrimaryKeySelective(PurSysUserRole record);

    int updateByPrimaryKey(PurSysUserRole record);
}