package com.ls.kafka.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ls.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2019-11-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="TbReptile对象", description="")
@TableName("tb_reptile")
public class TbReptile extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "导演")
    private String directors;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "评分")
    private String rate;

    @ApiModelProperty(value = "演员")
    private String casts;


}
