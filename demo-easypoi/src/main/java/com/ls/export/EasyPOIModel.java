package com.ls.export;

import com.ls.pojo.User;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by ls on 2019/4/4.
 */

@Data
public class EasyPOIModel implements Serializable {


    private static final long serialVersionUID = -2129851224740879544L;
    private String index;
    private String className;

    private User userInfo;

    public EasyPOIModel(String index, String className, User userInfo) {
        this.index = index;
        this.className = className;
        this.userInfo = userInfo;
    }
}