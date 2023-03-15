package com.example.tenderflex.repository.impl;

import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Tender;
import com.example.tenderflex.repository.TenderRepository;
import com.example.tenderflex.repository.mapper.TenderMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TenderRepositoryImpl implements TenderRepository {
    private final JdbcTemplate jdbcTemplate;

    public TenderRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Tender> getTendersByUserId(Long userId, Paging paging) {

         return jdbcTemplate.query("SELECT * FROM tender_flex.tender " +
                         "LEFT JOIN tender_flex.tender_status ON tender_status.id = tender.tender_status_id " +
                         "LEFT JOIN tender_flex.cpv ON cpv.cpv_id = tender.cpv_id " +
                 "WHERE \"user_id\" = ? ORDER BY tender.tender_id LIMIT ? OFFSET ?;", new TenderMapper(), userId,
                 paging.getCount(), paging.getIndex());
    }

    @Override
    public Integer getTendersCountByUserId(Long userId) {
        return jdbcTemplate.queryForObject("SELECT Count(*) FROM tender_flex.tender " +
                         "WHERE \"user_id\" = ?;", Integer.class, userId);
    }

    @Override
    public void createTender(Tender tender) {
         jdbcTemplate.update(
                         "INSERT INTO tender_flex.tender ("+
                                 "contractorname,"+
                                  "nationalRegNumber," +
                                 "towncity," +
                                 "contactPersonName," +
                                 "contactPersonsurname," +
                                 "phoneNumber," +
                                 "minValue," +
                                 "maxValue," +
                                 "publicDate," +
                                 "deadlineofsub," +
                                 "deadforsinging, " +
                                 "tender_name," +
                                 "country_id," +
                                 "cpv_id," +
                                 "type_id," +
                                 "currency_id," +
                                 "user_id ) " +
                 "VALUES (?,?,?, ?, ?, ?, ?,?, ?, ?, ?, ?,?,?, ?, ?, ?)",
                 tender.getContractorName(),
                 tender.getNationalRegNumber(),
                 tender.getTownCity(),
                 tender.getContactPersonName(),
                 tender.getContactPersonSurname(),
                 tender.getPhoneNumber(),
                 tender.getMinValue(),
                 tender.getMaxValue(),
                 tender.getPublicDate(),
                 tender.getDeadLineOfSub(),
                 tender.getDeadForSinging(),
                 tender.getName(),
                 tender.getCountryId(),
                 tender.getTenderTypeId(),
                 tender.getCurrencyId(),
                 tender.getUserId());

    }

    @Override
    public List <Tender > getAllTenders(Paging paging) {

        return jdbcTemplate.query("SELECT * FROM tender_flex.tender " +
                "LEFT JOIN tender_flex.tender_status ON tender_status.id = tender.tender_status_id " +
                "LEFT JOIN tender_flex.cpv ON cpv.cpv_id = tender.cpv_id " +
                " ORDER BY tender.tender_id " +
                "LIMIT ? OFFSET ? ",new TenderMapper(), paging.getCount(), paging.getIndex());
    }

    @Override
    public Integer getAllTendersCount() {
        return jdbcTemplate.queryForObject("SELECT Count(*) FROM tender_flex.tender",Integer.class);
    }

    @Override
    public Tender getTenderByTenderId( Long tenderId) {
        List <Tender> tenders =jdbcTemplate.query("SELECT * FROM tender_flex.tender " +
                        "LEFT JOIN tender_flex.tender_status ON tender_status.id = tender.tender_status_id " +
                        "LEFT JOIN tender_flex.cpv ON cpv.cpv_id = tender.cpv_id " +
                        " WHERE \"tender_id\" = ?;",
                new TenderMapper(),tenderId) ;
        if(tenders.isEmpty()) {
            return null;}
        return tenders.get(0);
    }


}

