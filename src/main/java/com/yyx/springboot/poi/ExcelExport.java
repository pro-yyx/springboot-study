package com.yyx.springboot.poi;

import java.lang.annotation.*;

/**
 * @Description: 自定义excel注解
 * @Auther: yinyuxin
 * @Date: 2018/12/21 10:54
 */
@Target(ElementType.FIELD) //标注用来注解field类型
@Documented  //标注该注解将被包含在javadoc中
@Retention(value = RetentionPolicy.RUNTIME) //注解既存在于class中，又可以通过反射在运行时获得
@Inherited //说明子类可以继承父类中的该注解
public @interface ExcelExport {

    //不设置默认值标识必填  String title() default "";

    /**
     * excel导出时的标题栏
     * @return
     */
    String title();

    /**
     * 导出时该字段的列号
     * @return
     */
    int index();

    /**
     * 用于格式化一些字段，由于是非必填项，所以要指定默认值
     * @return

    Class format() default String.class;//默认使用String.class只是标注,自定义的不可能是String.class
     */
}
