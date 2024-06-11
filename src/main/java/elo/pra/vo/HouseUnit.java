package elo.pra.vo;

import elo.pra.constants.SaleStatusEnum;
import elo.pra.constants.TypeEnum;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:18
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HouseUnit {
    private int id;
    /** 预售证号 */
    private String presalePermitNumber;
    /** 楼层 */
    private String floor;
    /** 类型 */
    private String category;
    /** 房间号 */
    private String roomNumber;
    /** 户型 */
    private String design;
    /** 套内面积 */
    private double interiorSize;
    /** 总建筑面积 */
    private double fullConstructSize;
    //    /** 销售状态 */
//    private String status;
//    /** 销售状态 */
//    private String color;
//    /** 销售状态 */
//    private String hexoCode;
    private SaleStatusEnum saleStatusEnum;
    //    /** 类型 */
//    private int[] typeCode;
//    /** 类型描述 */
//    private String[] typeDescription;
//    /** 类型对应的形状 */
//    private String[] typeShape;
//    /** 类型对应形状的名称 */
//    private String[] typeShapeName;
    private List<TypeEnum> types;
    /** 统计日期 即 插入日期 */
    private Date insertionDate;
    /** 修改日期 - 默认插入日期， 可能后期会用到，现预留 */
    private Date modificationDate;
    /** 查封 */
    private boolean isSealed;
    /** 抵押 */
    private boolean isMortgaged;

}

