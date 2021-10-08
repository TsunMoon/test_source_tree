package com.export.excel_ver1.mapper;

import com.export.excel_ver1.model.Roles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Roles> getAll();
}
