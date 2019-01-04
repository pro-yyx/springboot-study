package com.yyx.springboot.poi.easyPoi;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 课程po
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/12/25 15:06
 */
@Data
@ExcelTarget("course")
public class CoursePo implements Serializable {

    private static final long serialVersionUID = -8350784302101945155L;

    /**
     * 主键id
     */
    private int id;

    /**
     * 课程编码
     */
    @Excel(name = "课程编码")
    private String courseNo;

    /**
     * 课程名称
     */
    @Excel(name = "课程名称")
    private String courseName;

    /**
     * 教师
     */
    @ExcelEntity(id = "absent")
    private TeacherPo teacherPo;

    /**
     * 学生
     */
    @ExcelCollection(name = "学生")
    private List<StudentPo> students;
}
