package com.ls.service;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ls on 2020/3/27.
 */
public interface ItemService {

    /**
     * 导入
     * @param file
     * @return
     */
    Boolean excelItemImport(MultipartFile file, HttpServletResponse response) ;

    Boolean export(HttpServletResponse response) throws  Exception;
}
