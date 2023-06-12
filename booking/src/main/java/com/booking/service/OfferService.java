package com.booking.service;

import com.booking.entities.Offer;

import java.util.List;

public interface OfferService {
    Offer saveOffer(Offer offer);
    Offer getOfferById(Long id);
    List<Offer> getAllOffers();
    void deleteOfferById(Long id);
}
