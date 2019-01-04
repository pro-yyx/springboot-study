package com.yyx.springboot.poi.easyPoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Description: easypoi 自封装工具类
 * @Auther: yinyuxin
 * @Date: 2018/12/26 14:25
 */
public class EasypoiUtil {

    private static final Logger LOGGER=LoggerFactory.getLogger(EasypoiUtil.class);

    /**
     * 导出单sheet的excel
     * @param fileName
     * @param sheetName
     * @param datas
     * @param clz
     * @param response
     */
    public static void excelExportOfOneSheet(String fileName, String sheetName, List<T> datas, Class<T> clz, HttpServletResponse response) {
        try {
            ExportParams exportParams = new ExportParams(fileName, sheetName);
            Workbook workbook = ExcelExportUtil.exportExcel(exportParams, clz, datas);
            if (Objects.isNull(workbook)) {
                throw new RuntimeException("workbook为null");
            }
            downloadExcel(fileName,workbook,response);
        } catch (RuntimeException e) {
            LOGGER.error("EasypoiUtil工具类执行失败:{}",ExceptionUtils.getFullStackTrace(e));
            return;
        }
    }

    /**
     * 导出多sheet的excel
     * @param fileName
     * @param exportParamsForSheets
     * @param response
     */
  /*  public static void excelExportOfSheets(String fileName, List<WorkBookForSheets> exportParamsForSheets, HttpServletResponse response) {
        exportParamsForSheets = Optional.ofNullable(exportParamsForSheets).orElseGet(EasypoiUtil::get);
    }*/

    /**
     * 导出文件
     * @param fileName
     * @param workbook
     * @param response
     */
    private static void downloadExcel(String fileName, Workbook workbook, HttpServletResponse response) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Transfer-Encoding", "binary");
            //强制页面不缓存
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8") + ".xls");
            workbook.write(response.getOutputStream());
        } catch (Exception e) {

        }
    }

   /* private static List<WorkBookForSheets> get() {
        return new ArrayList<>().add(new WorkBookForSheets(null, null, "sheet1"));
    }*/

}
