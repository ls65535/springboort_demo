package com.ls.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;


@Data
public class BaseEntity  implements Serializable {

    private static final long serialVersionUID = 7001852719175358265L;
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Long id;

}
