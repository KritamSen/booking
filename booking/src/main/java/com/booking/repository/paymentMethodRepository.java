package com.booking.repository;

import com.booking.entities.UserPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paymentMethodRepository extends JpaRepository<UserPaymentMethod,Long> {
}
