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
    private final JdbcTemplate jdbcTemplate;

    public OfferRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Offer getOfferByTenderId(Long tenderId, Long userId) {
        List<Offer> offers = jdbcTemplate.query("SELECT * FROM tender_flex.offer " +
                "LEFT JOIN tender_flex.offer_status ON offer_status.id = offer.offer_status_id " +
                "where tender_flex.offer.tender_id = ? AND tender_flex.offer.user_id = ?;", new OfferMapper(),tenderId,userId);
        return offers.isEmpty() ? null : offers.get(0);
    }

    @Override
    public List<Offer> getAllOffers(Long userId, Paging paging) {
        return jdbcTemplate.query("SELECT * FROM tender_flex.offer " +
                        "LEFT JOIN tender_flex.offer_status ON offer_status.id = offer.offer_status_id " +
                        " Where \"user_id\"=? ORDER BY offer.offer_id LIMIT ? OFFSET ?;", new OfferMapper(), userId,
                paging.getCount(), paging.getIndex());
    }

    @Override
    public Integer getAllOffersCount(Long userId) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM tender_flex.offer " +
                        " Where \"user_id\"=?;", Integer.class, userId);
    }

    @Override
    public Offer getOfferByOfferIdForBidder(Long userId, Long offerId) {
        List<Offer> offer = jdbcTemplate.query("SELECT * FROM tender_flex.offer " +
                        "LEFT JOIN tender_flex.offer_status ON offer_status.id = offer.offer_status_id " +
                        " WHERE \"offer_id\"=? AND \"user_id\"=?;",
                new OfferMapper(), offerId, userId);
        if (offer.isEmpty()) {
            return null;
        }
        return offer.get(0);
    }

    @Override
    public Offer getOfferByOfferIdForContractor(Long userId, Long offerId) {
        List<Offer> offer = jdbcTemplate.query("SELECT * FROM tender_flex.offer " +
                        "LEFT JOIN tender_flex.offer_status ON offer_status.id = offer.offer_status_id " +
                        " WHERE \"offer_id\"=? AND tender_flex.offer.tender_id IN" +
                        " (SELECT tender.tender_id FROM tender_flex.tender where tender.user_id = ?)",
                new OfferMapper(), offerId, userId);
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
                         "offer_date," +
                         "currency_id," +
                         "country_id," +
                         "offer_file_key," +
                         "offer_status_id," +
                        "user_id)" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                offer.getName(),
                offer.getTenderId(),
                offer.getOfficialName(),
                offer.getNatRegNumber(),
                 offer.getTownCity(),
                offer.getContPersonName(),
                offer.getContPersonSurname(),
                offer.getPhoneNumber(),
                offer.getBidPrice(),
                offer.getOfferDate(),
                offer.getCurrencyId(),
                offer.getCountryId(),
                offer.getOfferFileKey(),
                 offer.getOfferStatus().getId(),
                offer.getUserId());
    }

    @Override
    public List<Offer> getOffersByTenders(Long userId, Paging page) {
        return jdbcTemplate.query("SELECT * FROM tender_flex.offer " +
                        "LEFT JOIN tender_flex.offer_status ON offer_status.id = offer.offer_status_id " +
                        " where tender_flex.offer.tender_id IN " +
                        "(SELECT tender.tender_id FROM tender_flex.tender where tender.user_id = ?) LIMIT ? OFFSET ?;"
                ,new OfferMapper(),
                userId,page.getCount(),page.getIndex());
    }

    @Override
    public Integer getOffersCountByTenders(Long userId) {
        return jdbcTemplate.queryForObject("SELECT Count(*) FROM tender_flex.offer " +
                        " where tender_flex.offer.tender_id" +
                        " IN (SELECT tender.tender_id FROM tender_flex.tender where tender.user_id = ?)", Integer.class, userId);
    }

    @Override
    public Integer getOffersCountByTenderId(Long tenderId,Long userId) {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tender_flex.offer " +
                "where tender_flex.offer.tender_id = ? AND tender_flex.offer.tender_id IN (SELECT tender.tender_id FROM " +
                "tender_flex.tender where tender.user_id=?);", Integer.class,tenderId,userId);
    }

    @Override
    public List<Offer> getOffersByTenderId(Long tenderId,Long userId) {
        return jdbcTemplate.query("SELECT * FROM tender_flex.offer " +
                "LEFT JOIN tender_flex.offer_status ON offer_status.id = offer.offer_status_id " +
                "where tender_flex.offer.tender_id = ? AND tender_flex.offer.tender_id IN (SELECT tender.tender_id FROM " +
                "tender_flex.tender where tender.user_id=?) " +
                "ORDER BY offer.offer_id;", new OfferMapper(),tenderId,userId);
    }

    @Override
    public void updateOfferStatus(Long offerId, Long statusId) {
        jdbcTemplate.update(
                "UPDATE tender_flex.offer SET offer_status_id = ? WHERE offer_id = ?;",
                    statusId,
                    offerId);
    }


}
