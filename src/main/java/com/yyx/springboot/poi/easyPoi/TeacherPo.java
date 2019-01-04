package com.yyx.springboot.poi.easyPoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 教师po
 * @Auther: yinyuxin
 * @Date: 2018/12/25 15:10
 */
@Data
@ExcelTarget("teacherPo")
public class TeacherPo implements Serializable {

    private static final long serialVersionUID = 7727974592796446785L;

    /**
     * 主键id
     */
    private int id;

    /**
     * 教师工号
     */
    @Excel(name = "教师工号")
    private String teacherNo;

    /**
     * 教师名称
     */
    @Excel(name = "主讲老师_major,代课老师_absent")
    private String teacherName;

    /**
     * 性别
     */
    @Excel(name = "性别_major,测试性别_absent",replace = {"男_true","女_false"})
    private Boolean sex;
}
