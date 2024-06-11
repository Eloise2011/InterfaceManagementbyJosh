package elo.pra.constants;

import lombok.Getter;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:20
 */
@Getter
public enum SaleStatusEnum {
    // 每个枚举常量表示一行记录，格式为：不可销售-红色-#db4924
    NOT_FOR_SALE("不可销售", "红色", "#db4924"),
    PRE_SALE("预售可售", "浅绿", "#99be3a"),
    NO_CERTIFICATION_NOT_FOR_SALE("确权不可售", "血红", "#940906"),
    CERTIFICATION_FOR_SALE("确权可售", "深绿", "#638314"),
    TRANSFERRED("已过户", "蓝绿", "#02807f"),
    FORCED_FREEZE("强制冻结", "蓝色", "#333397");

    private final String status;
    private final String color;
    private final String hexCode;

    SaleStatusEnum(String status, String color, String hexCode) {
        this.status = status;
        this.color = color;
        this.hexCode = hexCode;
    }

    @Override
    public String toString() {
        return "SaleStatusEnum{" +
                "status='" + status + '\'' +
                ", color='" + color + '\'' +
                ", hexCode='" + hexCode + '\'' +
                '}';
    }

    public static SaleStatusEnum fromString(String record) {
        // 使用 "-" 分割记录
        String[] parts = record.split("-");
        // 获取每个属性值
        String status = parts[0];
        String color = parts[1];
        String hexCode = parts[2];

        // 遍历枚举常量，找到与记录匹配的枚举
        for (SaleStatusEnum r : SaleStatusEnum.values()) {
            if (r.getStatus().equals(status) && r.getColor().equals(color) && r.getHexCode().equals(hexCode)) {
                return r;
            }
        }
        // 如果找不到匹配的枚举，返回 null
        return null;
    }
    public static SaleStatusEnum traverseMatch(String targetCode) {
        if (NOT_FOR_SALE.getHexCode().equals(targetCode))return NOT_FOR_SALE;
        if (PRE_SALE.getHexCode().equals(targetCode))return PRE_SALE;
        if (NO_CERTIFICATION_NOT_FOR_SALE.getHexCode().equals(targetCode))return NO_CERTIFICATION_NOT_FOR_SALE;
        if (CERTIFICATION_FOR_SALE.getHexCode().equals(targetCode))return CERTIFICATION_FOR_SALE;
        if (TRANSFERRED.getHexCode().equals(targetCode))return TRANSFERRED;
        if (FORCED_FREEZE.getHexCode().equals(targetCode))return FORCED_FREEZE;
        return null;
    }

    public static SaleStatusEnum fromFields(String status, String color, String hexCode) {
        for (SaleStatusEnum saleStatusEnum : values()) {
            if (saleStatusEnum.status.equalsIgnoreCase(status) && saleStatusEnum.color.equalsIgnoreCase(color) && saleStatusEnum.hexCode.equalsIgnoreCase(hexCode)) {
                return saleStatusEnum;
            }
        }
        throw new IllegalArgumentException("No matching SaleStatusEnum found for status: " + status
                + ", color: " + color + ", hexCode: " + hexCode);
    }
}
