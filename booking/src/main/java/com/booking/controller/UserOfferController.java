package com.booking.controller;

import com.booking.entities.UserOffer;
import com.booking.service.UserOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-offers")
public class UserOfferController {

    @Autowired
    private UserOfferService userOfferService;

    @PostMapping
    public UserOffer addUserOffer(@RequestBody UserOffer userOffer) {
        return userOfferService.addUserOffer(userOffer);
    }

    @DeleteMapping("/{userId}/{offerId}")
    public void deleteUserOffer(@PathVariable Long userId, @PathVariable Long offerId) {
        userOfferService.deleteUserOffer(userId, offerId);
    }
}
