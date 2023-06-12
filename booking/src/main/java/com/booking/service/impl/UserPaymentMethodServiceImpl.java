package com.booking.service.impl;

import com.booking.entities.PaymentResult;
import com.booking.entities.UserPaymentMethod;
import com.booking.repository.UserPaymentMethodRepository;
import com.booking.service.UserPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPaymentMethodServiceImpl implements UserPaymentMethodService {

            @Autowired
            private UserPaymentMethodRepository userPaymentMethodRepository;

            @Override
            public UserPaymentMethod saveUserPaymentMethod(UserPaymentMethod userPaymentMethod) {
                // Implement your logic to save the user payment method, including PayPal integration
                // Make use of PayPal SDK and API calls to handle payment processing and validation
                // Update the necessary fields in the UserPaymentMethod entity

                // Example code:
                PayPalService payPalService = new PayPalService();
                PaymentResult paymentResult = payPalService.processPayment(userPaymentMethod);

                // Update the userPaymentMethod object based on the payment result
                userPaymentMethod.setPaymentType(paymentResult.getStatus());

                // Save the updated userPaymentMethod object to the database
                return userPaymentMethodRepository.save(userPaymentMethod);
            }

            @Override
            public List<UserPaymentMethod> getAllUserPaymentMethods() {
                return userPaymentMethodRepository.findAll();
            }

            @Override
            public UserPaymentMethod getUserPaymentMethodById(Long id) {
                Optional<UserPaymentMethod> optionalUserPaymentMethod = userPaymentMethodRepository.findById(id);
                return optionalUserPaymentMethod.orElse(null);
            }

            @Override
            public void deleteUserPaymentMethod(Long id) {
                userPaymentMethodRepository.deleteById(id);
            }
        }


