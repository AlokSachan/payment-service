package com.wipro.service;

import com.wipro.entity.PaymentEntity;
import com.wipro.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public List<PaymentEntity> getAllPaymentDetail() {
        return paymentRepository.findAll();
    }

    @Override
    public PaymentEntity newPayment(PaymentEntity paymentEntity) {
        return paymentRepository.save(paymentEntity);
    }

    @Override
    public PaymentEntity getPaymentDetails(Integer id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public PaymentEntity updatePayment(PaymentEntity paymentEntity) {
        return paymentRepository.save(paymentEntity);
    }

    @Override
    public void deletePayment(Integer id) {
        PaymentEntity paymentDetails = getPaymentDetails(id);
        paymentRepository.delete(paymentDetails);
    }
}
