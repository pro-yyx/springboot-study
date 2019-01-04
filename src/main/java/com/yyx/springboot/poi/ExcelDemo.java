package com.yyx.springboot.poi;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: excel导出
 * @Auther: yinyuxin
 * @Date: 2018/12/21 21:34
 */
@Data
public class ExcelDemo implements Serializable {
    private static final long serialVersionUID = 2933712544883004943L;

    @ExcelExport(title = "姓名",index = 1)
    private String name;

    @ExcelExport(title = "身份证号",index = 2)
    private String idCard;

    @ExcelExport(title = "年龄",index = 3)
    private Integer age;

    @ExcelExport(title = "性别",index = 4)
    private Boolean sex;

    @ExcelExport(title = "生日",index=4)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
