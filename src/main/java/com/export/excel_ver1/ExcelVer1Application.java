package com.export.excel_ver1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.export.excel_ver1.mapper")
@SpringBootApplication
public class ExcelVer1Application {

    public static void main(String[] args) {
        SpringApplication.run(ExcelVer1Application.class, args);
    }

}
