package com.ls.pojo;


import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


/**
 * <p>
 * 商品表
 * </p>
 *
 * @author jobob
 * @since 2019-10-10
 */
@Data
@ApiModel(value = "Item对象", description = "商品表")
@TableName("tb_item")
public class Item implements Serializable {

    public Item(String title, String sellPoint, Double price, Integer num, String image,
        Long cid, String brand) {
        this.title = title;
        this.sellPoint = sellPoint;
        this.price = price;
        this.num = num;
        this.image = image;
        this.cid = cid;
        this.brand = brand;
    }

    public Item() {
        super();
    }

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @Excel(name = "商品标题", orderNum = "1")
    @ApiModelProperty(value = "商品标题")
    private String title;

    @Excel(name = "商品卖点", orderNum = "2")
    @ApiModelProperty(value = "商品卖点")
    private String sellPoint;

    @Excel(name = "商品价格", orderNum = "3")
    @ApiModelProperty(value = "商品价格，单位为：分")
    private Double price;

    @Excel(name = "库存数量", orderNum = "3")
    @ApiModelProperty(value = "库存数量")
    private Integer num;
    @Excel(name = "品牌", orderNum = "4")
    @ApiModelProperty(value = "品牌")
    private String brand;

    @Excel(name = "商品条形码", orderNum = "5")
    @ApiModelProperty(value = "商品条形码")
    private String barcode;

    @Excel(name = "商品图片", orderNum = "6")
    @ApiModelProperty(value = "商品图片")
    private String image;


    @Excel(name = "所属类目", orderNum = "7")
    @ApiModelProperty(value = "所属类目，叶子类目")
    private Long cid;


    @Excel(name = "商品状态", orderNum = "8")
    @ApiModelProperty(value = "商品状态，1-正常，2-下架，3-删除")
    private Integer status;


    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    private Date updated;

}
