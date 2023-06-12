package com.booking.controller;

import com.booking.entities.Offer;
import com.booking.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public Offer getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }

    @PostMapping
    public Offer saveOffer(@RequestBody Offer offer) {
        return offerService.saveOffer(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOfferById(@PathVariable Long id) {
        offerService.deleteOfferById(id);
    }
}
