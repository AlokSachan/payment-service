package com.wipro.controller;

import com.wipro.entity.PaymentEntity;
import com.wipro.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaymentEntity>> getAllPaymentDetail() {
        return new ResponseEntity<>(paymentService.getAllPaymentDetail(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentEntity> newPayment(@RequestBody PaymentEntity paymentEntity) {
        return new ResponseEntity<>(paymentService.newPayment(paymentEntity), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentEntity> getPaymentDetails(@PathVariable Integer id) {
        return new ResponseEntity<>(paymentService.getPaymentDetails(id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentEntity> updatePayment(@RequestBody PaymentEntity paymentEntity) {
        return new ResponseEntity<>(paymentService.updatePayment(paymentEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
