package com.export.excel_ver1.mapper;

import com.export.excel_ver1.model.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<Users> getAll();
}
