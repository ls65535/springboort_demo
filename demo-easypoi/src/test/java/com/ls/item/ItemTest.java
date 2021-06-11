package com.ls.item;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.ls.pojo.UserTab;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ls on 2020/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemTest {

    @Test
    public void  testImport () throws IOException {
        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        long start = new Date().getTime();
        ClassPathResource classPathResource = new ClassPathResource("templates/userImport.xls");
        File file = classPathResource.getFile();
        List<UserTab> list = ExcelImportUtil.importExcel(file,UserTab.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
        System.out.println(list);
    }

}
