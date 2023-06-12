package com.booking.service;

import com.booking.entities.Offer;
import com.booking.entities.User;
import com.booking.entities.UserOffer;
import com.booking.repository.OfferRepository;
import com.booking.repository.UserOfferRepository;
import com.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOfferServiceImpl implements UserOfferService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private UserOfferRepository userOfferRepository;

    @Override
    public UserOffer addUserOffer(UserOffer userOffer) {
        User user = userOffer.getUser();
        Offer offer = userOffer.getOffer();

        user = userRepository.findById(user.getId()).orElse(null);
        offer = offerRepository.findById(offer.getId()).orElse(null);

        if (user != null && offer != null) {
            userOffer.setUser(user);
            userOffer.setOffer(offer);
            return userOfferRepository.save(userOffer);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUserOffer(Long userId, Long offerId) {
        User user = userRepository.findById(userId).orElse(null);
        Offer offer = offerRepository.findById(offerId).orElse(null);

        if (user != null && offer != null) {
            UserOffer userOffer = new UserOffer();
            userOffer.setUser(user);
            userOffer.setOffer(offer);

            userOfferRepository.delete(userOffer);
        }
    }
}
