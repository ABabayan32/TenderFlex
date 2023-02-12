package com.example.tenderflex.repository.impl;
import com.example.tenderflex.model.Paging;
import com.example.tenderflex.model.Offer;
import com.example.tenderflex.repository.OfferRepository;

import com.example.tenderflex.repository.mapper.OfferMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OfferRepositoryImpl implements OfferRepository {
    public final JdbcTemplate jdbcTemplate;

    public OfferRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Offer> getOffersByTenderId(Long tenderId,Long userId, Paging paging) {
        List<Offer> offer = jdbcTemplate.query("SELECT * FROM tender_flex.offer  " +
                        "where tender_flex.offer.tender_id IN(SELECT tender.tender_id FROM " +
                        "tender_flex.tender where tender.user_id=?) " +
                        "ORDER BY offer.offer_id LIMIT ? OFFSET ?;", new OfferMapper(),userId ,
                paging.getCount(), paging.getIndex());
        if (offer.isEmpty()) {
            return null;
        }
        return offer;
    }

    @Override
    public List<Offer> getAllOffers(Long userId, Paging paging) {
        return jdbcTemplate.query("SELECT *FROM tender_flex.offer " +
                        "Where \"user_id\"=? ORDER BY offer.offer_id LIMIT ? OFFSET ?;", new OfferMapper(), userId,
                paging.getCount(), paging.getIndex());
    }

    @Override
    public Offer getOfferByOfferId(Long offerId) {
        List<Offer> offer = jdbcTemplate.query("SELECT *FROM tender_flex.offer WHERE \"offer_id\"=?; ",
                new OfferMapper(), offerId);
        if (offer.isEmpty()) {
            return null;
        }
        return offer.get(0);
    }

    @Override
    public void createOffer(Offer offer) {
         jdbcTemplate.update(
                 "INSERT INTO tender_flex.offer (" +
                         "offer_name,"+
                         "tender_id,"+
                        "official_name," +
                        "nat_reg_number," +
                        "town_city," +
                        "cont_person_name," +
                        "cont_person_surname," +
                        "phone_number," +
                        "bid_price," +
                        "user_id)" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)",
                offer.getName(),
                offer.getTenderId(),
                offer.getOfficialName(),
                offer.getNatRegNumber(),
                 offer.getTownCity(),
                offer.getContPersonName(),
                offer.getContPersonSurname(),
                offer.getPhoneNumber(),
                offer.getBidPrice(),
                offer.getUserId());
    }

    @Override
    public List<Offer> getOffersByTenders(Long userId, Paging page) {
        List <Offer> offers =jdbcTemplate.query("SELECT * FROM tender_flex.offer where tender_flex.offer.tender_id" +
                        " IN (SELECT tender.tender_id FROM tender_flex.tender where tender.user_id = ?) LIMIT ? OFFSET ?;"
                ,new OfferMapper(),
                userId,page.getCount(),page.getIndex());
        if(offers.isEmpty()){
            return null;
        }
        return offers;
    }
}
