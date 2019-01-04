package com.yyx.springboot.poi.easyPoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 学生po
 * @Auther: yinyuxin
 * @Date: 2018/12/25 15:10
 */
@Data
@ExcelTarget("studentPo")
public class StudentPo implements Serializable {


    private static final long serialVersionUID = -4944792526817089146L;
    /**
     * 主键id
     */
    private int id;

    /**
     * 学生学号
     */
    @Excel(name = "学生学号")
    private String studentNo;

    /**
     * 学生名称
     */
    @Excel(name = "学生大名_major,学生全名_absent")
    private String studentName;

    /**
     * 性别
     */
    @Excel(name = "性别_major,测试性别_absent",replace = {"男_true","女_false"})
    private Boolean sex;

    /**
     * 生日
     */
    @Excel(name = "生日",format = "yyyy-MM-dd")
    private Date birthday;
}
