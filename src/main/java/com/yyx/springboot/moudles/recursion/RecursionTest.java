package com.yyx.springboot.moudles.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: yinyuxin
 * @Date: 2018/12/11 19:12
 */
public class RecursionTest {
    // 查询数据库菜单表中所有数据(这里模拟一个菜单表的所有数据)
    static int times=0;
    static List<MenuTreeEntity> data = new ArrayList<MenuTreeEntity>();
    static {
        MenuTreeEntity l = new MenuTreeEntity(1, "北京市", 0,1);

        MenuTreeEntity l2 = new MenuTreeEntity(3, "朝阳区", 1,2);
        MenuTreeEntity l4 = new MenuTreeEntity(5, "大郊亭中街", 3,3);
        MenuTreeEntity l11 = new MenuTreeEntity(12, "二号院", 5,4);
        MenuTreeEntity l12 = new MenuTreeEntity(13, "三号楼", 12,5);
        MenuTreeEntity l13 = new MenuTreeEntity(14, "四号楼", 12,5);
        MenuTreeEntity l5 = new MenuTreeEntity(6, "大望路", 3,3);
        MenuTreeEntity l6 = new MenuTreeEntity(7, "南磨房路", 3,3);
        MenuTreeEntity l3 = new MenuTreeEntity(4, "海淀区", 1,2);
        MenuTreeEntity l7 = new MenuTreeEntity(8, "唐家岭路", 4,3);
        MenuTreeEntity l8 = new MenuTreeEntity(9, "上地路", 4,3);

        MenuTreeEntity l1 = new MenuTreeEntity(2, "天津市", 0,1);
        MenuTreeEntity l9 = new MenuTreeEntity(10, "红桥区", 2,2);
        MenuTreeEntity l10 = new MenuTreeEntity(11, "北辰区", 2,2);

        data.add(l2);
        data.add(l);
        data.add(l1);
        data.add(l3);
        data.add(l10);
        data.add(l9);
        data.add(l5);
        data.add(l4);
        data.add(l7);
        data.add(l6);
        data.add(l8);
        data.add(l12);
        data.add(l11);
        data.add(l13);
    }

    public static void main(String[] args) {
        List<MenuTreeEntity> resultList = new ArrayList<>();
        System.out.println("查询前集合大小:"+data.size());
        long start = System.currentTimeMillis();
        for (MenuTreeEntity MenuTreeEntity : data) {
            times++;
            if (MenuTreeEntity.getParentId()==0) {//父级菜单开始添加
                resultList.add(MenuTreeEntity);
                if (ifChilds(data, MenuTreeEntity.getId())) {//存在子集
                    List<MenuTreeEntity> childs = new ArrayList<>();
                    childs = getChildList(data,MenuTreeEntity.getId(),childs);
                    resultList.addAll(childs);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("查询后集合大小:"+resultList.size());
        System.out.println("查询次数:"+times+"次");
        System.out.println("查询耗时:"+(end-start)+"毫秒");

        for (MenuTreeEntity MenuTreeEntity : resultList) {
            String s = "";
            for (int i = 1; i < MenuTreeEntity.getLevel(); i++) {
                s = s + "\t";
            }
            System.out.println(s+"I____"+MenuTreeEntity.getName());
        }

    }

    //获取父id下的子集合
    private static List<MenuTreeEntity> getChildList(List<MenuTreeEntity> list,int pId,List<MenuTreeEntity> reList) {
        for (MenuTreeEntity MenuTreeEntity : list) {
            times++;
            if (MenuTreeEntity.getParentId()==pId) {//查询下级菜单
                reList.add(MenuTreeEntity);
                if (ifChilds(list, MenuTreeEntity.getId())) {
                    getChildList(list, MenuTreeEntity.getId(), reList);
                }
            }
        }
        return reList;
    }

    //判断是否存在子集
    private static boolean ifChilds(List<MenuTreeEntity> list,int pId) {
        boolean flag = false;
        for (MenuTreeEntity MenuTreeEntity : list) {
            times++;
            if (MenuTreeEntity.getParentId()==pId) {
                flag=true;
                break;
            }
        }
        return flag;
    }


}
