package com.yyx.springboot.moudles.recursion;

import lombok.Data;

/**
 * @Description: 递归学习  （菜单树entity）
 * @Auther: yinyuxin@gome.com.cn
 * @Date: 2018/12/11 19:10
 */
@Data
public class MenuTreeEntity {

    private int id;
    private String name;
    private int parentId;
    private int level;

    public MenuTreeEntity(int id, String name, int parentId, int level) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.level = level;
    }
}
