package elo.pra.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import elo.pra.constants.TypeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2024-06-10 21:22
 */
@MappedTypes(TypeEnum.class)
public class TypeEnumListTypeHandler extends BaseTypeHandler<List<TypeEnum>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<TypeEnum> typeEnums, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public List<TypeEnum> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public List<TypeEnum> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public List<TypeEnum> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}