package com.booking.service;

import com.booking.entities.UserOffer;

public interface UserOfferService {
    UserOffer addUserOffer(UserOffer userOffer);
    void deleteUserOffer(Long userId, Long offerId);
}
