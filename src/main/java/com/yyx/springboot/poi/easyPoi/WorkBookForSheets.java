package com.yyx.springboot.poi.easyPoi;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: easypoi 多sheet导出 参数接受
 * @Auther: yinyxin@gome.com.cn
 * @Date: 2018/12/26 20:04
 */
@Data
public class WorkBookForSheets implements Serializable {

    private static final long serialVersionUID = -7341939183577851522L;

    private Class<T> clz;

    private List<T> datas;

    private String sheetName;

    public WorkBookForSheets(Class<T> clz, List<T> datas, String sheetName) {
        this.clz = clz;
        this.datas = datas;
        this.sheetName = sheetName;
    }

    public WorkBookForSheets() {
        super();
    }
}
