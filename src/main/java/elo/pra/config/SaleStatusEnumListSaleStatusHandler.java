package elo.pra.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import elo.pra.constants.SaleStatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-11 22:35
 */
@MappedTypes(SaleStatusEnumListSaleStatusHandler.class)
public class SaleStatusEnumListSaleStatusHandler extends BaseTypeHandler<SaleStatusEnum> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SaleStatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getStatus());
        ps.setString(i + 1, parameter.getColor());
        ps.setString(i + 2, parameter.getHexCode());
    }

    @Override
    public SaleStatusEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String status = rs.getString("status");
        String color = rs.getString("color");
        String hexCode = rs.getString("hex_code");
        return SaleStatusEnum.fromFields(status, color, hexCode);
    }

    @Override
    public SaleStatusEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String status = rs.getString(columnIndex);
        String color = rs.getString(columnIndex + 1);
        String hexCode = rs.getString(columnIndex + 2);
        return SaleStatusEnum.fromFields(status, color, hexCode);
    }

    @Override
    public SaleStatusEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String status = cs.getString(columnIndex);
        String color = cs.getString(columnIndex + 1);
        String hexCode = cs.getString(columnIndex + 2);
        return SaleStatusEnum.fromFields(status, color, hexCode);
    }
}
