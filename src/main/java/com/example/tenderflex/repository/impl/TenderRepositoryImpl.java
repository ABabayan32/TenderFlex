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


         List<Tender> tender = jdbcTemplate.query("SELECT * FROM tender_flex.tender  " +
                 "WHERE \"user_id\" = ? ORDER BY tender.tender_id LIMIT ? OFFSET ?;", new TenderMapper(), userId,
                 paging.getCount(), paging.getIndex());
        if (tender.isEmpty()) {
            return null; }
        return tender;
    }

    @Override
    public void createTender(Tender tender) {
         jdbcTemplate.update(
                         "INSERT INTO tender_flex.tender (" +
                                 "contractorname," +
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
                                 "user_id)"+
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
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
                 tender.getUserId()
         );

    }

    @Override
    public List <Tender > getAllTenders(Paging paging) {
        List <Tender> tenders =jdbcTemplate.query("SELECT * FROM tender_flex.tender ORDER BY tender.tender_id " +
                "LIMIT ? OFFSET ? ",new TenderMapper(), paging.getCount(), paging.getIndex());
        if (tenders.isEmpty()) {
            return null; }
        return tenders;
    }

    @Override
    public Tender getTenderByTenderId( Long tenderId) {
        List <Tender> tenders =jdbcTemplate.query("SELECT * FROM tender_flex.tender WHERE \"tender_id\" = ?;",
                new TenderMapper(),tenderId) ;
        if(tenders.isEmpty()) {
            return null;}
        return tenders.get(0);
    }


}

