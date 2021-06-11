package com.ls.controller;

import com.ls.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ls on 2020/3/27. new ClassPathResource("jwt.jks")
 */
@RestController
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private ItemService itemService;

    /**
     * Excel批量导入根据模板，错误的再导出
     */
    @ApiOperation(value = "Excel批量导入", tags = {"item"})
    @PostMapping("/excelImport")
    public Boolean excelImport(HttpServletResponse response,
        @ApiParam(value = "上传的文件", required = true) @RequestParam("file") MultipartFile file) {
        Boolean flag = itemService.excelItemImport(file, response);
        return flag;

    }

    /**
     * Excel批量导入根据模板，错误的再导出
     */
    @ApiOperation(value = "export导出", tags = {"item"})
    @GetMapping("/export")
    public Boolean export(HttpServletResponse response) throws Exception {
        Boolean flag = itemService.export(response);
        return flag;

    }

}
