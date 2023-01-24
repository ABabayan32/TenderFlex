package com.example.tenderflex.repository.mapper;

import com.example.tenderflex.model.Tender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TenderMapper implements RowMapper<Tender> {

    @Override

    public Tender mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Tender(rs.getLong("tender_id"),
                rs.getString("tender_name"),
                rs.getLong("user_id"),
                rs.getString("contractorName"),
                rs.getString("nationalRegNumber"),
                rs.getString("townCity"),
                rs.getString("contactPersonName"),
                rs.getString("contactPersonSurname"),
                rs.getString("phoneNumber"),
                rs.getDouble("minValue"),
                rs.getDouble("maxValue"),
                rs.getLong("publicDate"),
                rs.getLong("deadLineOfSub"),
                rs.getLong("deadForSinging")

        );

    }
}