package com.booking.controller;


import com.booking.entities.UserPaymentMethod;
import com.booking.service.UserPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
        @RequestMapping("/user-payment-methods")
        public class UserPaymentMethodController {

            @Autowired
            private UserPaymentMethodService userPaymentMethodService;

            @PostMapping
            public ResponseEntity<UserPaymentMethod> saveUserPaymentMethod(@RequestBody UserPaymentMethod userPaymentMethod) {
                UserPaymentMethod savedPaymentMethod = userPaymentMethodService.saveUserPaymentMethod(userPaymentMethod);
                return ResponseEntity.ok(savedPaymentMethod);
            }

            @GetMapping
            public ResponseEntity<List<UserPaymentMethod>> getAllUserPaymentMethods() {
                List<UserPaymentMethod> paymentMethods = userPaymentMethodService.getAllUserPaymentMethods();
                return ResponseEntity.ok(paymentMethods);
            }

            @GetMapping("/{id}")
            public ResponseEntity<UserPaymentMethod> getUserPaymentMethodById(@PathVariable Long id) {
                UserPaymentMethod paymentMethod = userPaymentMethodService.getUserPaymentMethodById(id);
                if (paymentMethod != null) {
                    return ResponseEntity.ok(paymentMethod);
                } else {
                    return ResponseEntity.notFound().build();
                }
            }

            @DeleteMapping("/{id}")
            public ResponseEntity<Void> deleteUserPaymentMethod(@PathVariable Long id) {
                userPaymentMethodService.deleteUserPaymentMethod(id);
                return ResponseEntity.noContent().build();
            }
        }



    // Add other methods such as getting user payment methods, updating, deleting, etc.
