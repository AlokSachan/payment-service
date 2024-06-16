package com.wipro.service;

import com.wipro.entity.PaymentEntity;

import java.util.List;

public interface PaymentService {
    List<PaymentEntity> getAllPaymentDetail();

    PaymentEntity newPayment(PaymentEntity paymentEntity);

    PaymentEntity getPaymentDetails(Integer id);

    PaymentEntity updatePayment(PaymentEntity paymentEntity);

    void deletePayment(Integer id);
}
