package com.booking.service;

import com.booking.entities.UserPaymentMethod;

import java.util.List;

public interface UserPaymentMethodService {
            UserPaymentMethod saveUserPaymentMethod(UserPaymentMethod userPaymentMethod);

            List<UserPaymentMethod> getAllUserPaymentMethods();

            UserPaymentMethod getUserPaymentMethodById(Long id);

            void deleteUserPaymentMethod(Long id);
        }




