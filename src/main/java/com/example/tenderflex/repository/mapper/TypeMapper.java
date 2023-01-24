package com.example.tenderflex.repository.mapper;
import com.example.tenderflex.model.Type;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TypeMapper implements RowMapper<Type> {
    public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Type (rs.getInt("type_id") ,
                rs.getString("type_name") );

}
}