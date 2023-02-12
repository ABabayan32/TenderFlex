package com.example.tenderflex.repository.mapper;

import com.example.tenderflex.model.Tender;
import com.example.tenderflex.model.TenderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class TenderMapper implements RowMapper<Tender> {

    @Override

    public Tender mapRow(ResultSet rs, int rowNum) throws SQLException {
        long tenderStatusId = rs.getLong("id");
        TenderStatus tenderStatus = null;
        if(tenderStatusId != 0){
            tenderStatus = new TenderStatus(tenderStatusId, rs.getString("name"));
        }
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
                rs.getLong("deadForSinging"),
                tenderStatus,
                rs.getString("contract_file_key"),
                rs.getString("decline_file_key"),
                rs.getString("award_file_key"),
                rs.getLong("country_id"),
                rs.getLong("cpv_id"),
                rs.getLong("type_id"),
                rs.getLong("currency_id")
        );

    }
}