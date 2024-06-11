package elo.pra.constants;

import lombok.Getter;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 20:19
 */
@Getter
public enum TypeEnum {
    NOT_FOR_PRESALE(0, "未纳入预售", "★", "SOLID_ASTERISK"),
    RELOCATION_HOUSE(1, "回迁房", "△", "HOLLOW_TRIANGLE"),
    SELF_USE_ROOM(2, "自用房", "□", "HOLLOW_RECTANGLE"),
    PUBLIC_FACILITIES(3, "公建配套", "☆", "HOLLOW_ASTERISK"),
    DIRECT_MANAGEMENT_ROOM(4, "直管房", "▲", "SOLID_TRIANGLE"),
    DIVISION(5, "分成", "〓", "EQUAL_SIGN"),
    MORTGAGED(6, "抵押", "◆", "SOLID_DIAMOND"),
    SEALED(7, "查封", "●", "SOLID_CIRCLE"),
    SIGNED(8, "已签约", "◎", "HOLLOW_CIRCLE"),
    ALREADY_FILED(9, "已备案", "■", "SOLID_RECTANGLE");

    private final int typeCode;
    private final String typeDescription;
    private final String typeShape;
    private final String typeShapeName;

    TypeEnum(int typeCode, String typeDescription, String typeShape, String typeShapeName) {
        this.typeCode = typeCode;
        this.typeDescription = typeDescription;
        this.typeShape = typeShape;
        this.typeShapeName = typeShapeName;
    }

    public static TypeEnum traverseMatch(String targetCode) {
        if (targetCode.equalsIgnoreCase(NOT_FOR_PRESALE.typeShape)) return NOT_FOR_PRESALE;
        if (targetCode.equalsIgnoreCase(RELOCATION_HOUSE.typeShape)) return RELOCATION_HOUSE;
        if (targetCode.equalsIgnoreCase(SELF_USE_ROOM.typeShape)) return SELF_USE_ROOM;
        if (targetCode.equalsIgnoreCase(PUBLIC_FACILITIES.typeShape)) return PUBLIC_FACILITIES;
        if (targetCode.equalsIgnoreCase(DIRECT_MANAGEMENT_ROOM.typeShape)) return DIRECT_MANAGEMENT_ROOM;
        if (targetCode.equalsIgnoreCase(DIVISION.typeShape)) return DIVISION;
        if (targetCode.equalsIgnoreCase(MORTGAGED.typeShape)) return MORTGAGED;
        if (targetCode.equalsIgnoreCase(SEALED.typeShape)) return SEALED;
        if (targetCode.equalsIgnoreCase(SIGNED.typeShape)) return SIGNED;
        if (targetCode.equalsIgnoreCase(ALREADY_FILED.typeShape)) return ALREADY_FILED;
        return null;
    }

    @Override
    public String toString() {
        return "TypeEnum{" +
                "statusCode=" + typeCode +
                ", statusDescription='" + typeDescription + '\'' +
                ", typeShape='" + typeShape + '\'' +
                ", typeShapeName='" + typeShapeName + '\'' +
                '}';
    }

    public static TypeEnum fromFields(int typeCode, String typeDescription, String typeShape,String typeShapeName) {
        for (TypeEnum typeEnum : values()) {
            if (typeEnum.typeCode == typeCode && typeEnum.typeDescription.equals(typeDescription) && typeEnum.typeShape.equals(typeShape) && typeEnum.typeShapeName.equals(typeShapeName)) {
                return typeEnum;
            }
        }
        throw new IllegalArgumentException("No matching TypeEnum found for typeCode: " + typeCode + ", typeDescription: " + typeDescription + ", typeShape: " + typeShape);
    }
}
