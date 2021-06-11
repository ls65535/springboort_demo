package com.ls.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.ls.export.EasyPOIModel;
import com.ls.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ls on 2019/4/4.
 *
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {


    /**
     * 使用easypoi导出文件 单sheet / 多sheet
     */
    @ApiOperation(value = "导出文件 单sheet",tags = {"user"})
   @GetMapping("/test")
    @ResponseBody
    public String exportExcelTest(HttpServletResponse response) {
        // 获取workbook对象
        // 单sheet或多sheet 只需要更改此处即可
        Workbook workbook = exportMoreSheetByTemplate();
        // 判断数据
        if (workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
        String excelName = "测试excel";
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = excelName + "-" + sdf.format(new Date());
        // 指定下载的文件名--设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" + dateStr + ".xls");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 写出数据输出流到页面
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    /**
     * 模版多sheet导出示例
     */
    public Workbook exportMoreSheetByTemplate() {
        // 查询数据,此处省略
        List<EasyPOIModel> list = new ArrayList<EasyPOIModel>();
        int count1 = 0;
        // 学生信息
        User user1 = new User("张三", "男", 20, "北京市东城区", "篮球");
        User user2 = new User("李四", "男", 17, "北京市西城区", "游泳");
        User user3 = new User("淑芬", "女", 34, "北京市丰台区", "唱歌，跳舞");
        User user4 = new User("仲达", "男", 55, "北京市昌平区", "象棋，足球");
        // sheet1内容

        EasyPOIModel easyPOIModel11 = new EasyPOIModel(String.valueOf(count1++), "信科", user1);
        EasyPOIModel easyPOIModel12 = new EasyPOIModel(String.valueOf(count1++), "生工", user2);
        EasyPOIModel easyPOIModel13 = new EasyPOIModel(String.valueOf(count1++), "化工", user3);
        EasyPOIModel easyPOIModel14 = new EasyPOIModel(String.valueOf(count1++), "信科", user4);
        list.add(easyPOIModel11);
        list.add(easyPOIModel12);
        list.add(easyPOIModel13);
        list.add(easyPOIModel14);
        // 存放数据map
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("list", list);
        // sheet2内容
        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map1.put("lists", userList);

        // 设置导出配置
        // 获取导出excel指定模版
        ClassPathResource classPathResource = new ClassPathResource("templates/exportUser.xls");
        String path = classPathResource.getPath();
        TemplateExportParams params = new TemplateExportParams(path, true);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        String[] sheetNameArray = {"班级信息", "学生信息"};
        params.setSheetName(sheetNameArray);
        // 导出excel
        return ExcelExportUtil.exportExcel(params, map1);
    }
}


