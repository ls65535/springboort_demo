package com.ls.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import lombok.Data;

@Data
public class UserTab implements Serializable {
    private static final long serialVersionUID = -2143595433523717391L;
    @Excel(name = "ID")
    private Integer id;
    @Excel(name = "姓名", orderNum = "1")
    private String name;
    @Excel(name = "年龄", orderNum = "2")
    private Integer age;
    @Excel(name = "性别", orderNum = "3")
    private String sex;
}