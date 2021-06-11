package com.ls.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.ls.mapper.ItemMapper;
import com.ls.pojo.Item;
import com.ls.service.ItemService;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ls on 2020/3/27.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public Boolean excelItemImport(MultipartFile file, HttpServletResponse response) {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        // long start = new Date().getTime();
        List<Item> dbItems = itemMapper.selectList(null);
        List<Item> list = null;
        try {
          //  list = ExcelImportUtil.importExcel(file.getInputStream(), Item.class, params);
            // Collection<Item> disjunction = CollectionUtils.intersection(list, dbItems);
            Workbook sheets = this.exportList(dbItems);
            getExportExcel(response, sheets);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean export(HttpServletResponse response) throws Exception {

// 获取workbook对象
        // 单sheet或多sheet 只需要更改此处即可
        List<Item> items = itemMapper.selectList(null);
        Workbook workbook = exportList(items);
        return getExportExcel(response, workbook);
    }

    private Boolean getExportExcel(HttpServletResponse response, Workbook workbook) throws IOException {
        // 判断数据
        // 设置excel的文件名称
        String excelName = "data";
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = excelName + "-" + sdf.format(new Date());
        // 指定下载的文件名--设置响应头
        String filename = dateStr + ".xls";
        response.addHeader("Content-Disposition", "attachment;fileName=" + filename);// 设置文件名
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setCharacterEncoding("UTF-8");
        // 写出数据输出流到页面
        OutputStream output = null;
        BufferedOutputStream bufferedOutPut = null;

        try {
            output = response.getOutputStream();
            bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedOutPut.close();
            output.close();
        }
        return false;
    }

    /**
     * 模版多sheet导出示例
     */
    public Workbook exportList(Collection collection) {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("商品", "商品信息"),
            Item.class, collection);
        return workbook;
    }


}
