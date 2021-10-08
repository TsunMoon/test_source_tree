package com.export.excel_ver1.controller;

import com.export.excel_ver1.mapper.UserMapper;
import com.export.excel_ver1.model.Users;
import com.export.excel_ver1.utils.ExcelExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/all")
    public List<Users> getAllUser(){
        return userMapper.getAll();
    }

    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey,headerValue);

        List<Users> users = userMapper.getAll();

        ExcelExport excelExport = new ExcelExport(users);
        excelExport.export(response);
    }

}
