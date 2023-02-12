package com.example.tenderflex.repository.mapper;

import com.example.tenderflex.model.Offer;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferMapper implements RowMapper<Offer> {

    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Offer(rs.getInt("offer_id"),
                rs.getString("offer_name"),
                rs.getString("official_name"),
                rs.getString("nat_reg_number"),
                rs.getString("town_city"),
                rs.getString("cont_person_name"),
                rs.getString("cont_person_surname"),
                rs.getString("phone_number"),
                rs.getInt("bid_price"),
                rs.getLong("user_id"),
                rs.getLong("tender_id")
        );
    }
}
