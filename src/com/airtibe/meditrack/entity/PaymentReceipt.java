package com.airtibe.meditrack.entity;



import java.time.LocalDateTime;
import java.util.UUID;

import com.airtibe.meditrack.enums.PaymentStatus;

public final class PaymentReceipt {

    private final String receiptId;
    private final String billSummaryId;
    private final double paidAmount;
    private final LocalDateTime paymentDate;
    private final String paymentMethod;
    private final PaymentStatus status;

    public PaymentReceipt(String billSummaryId,
                          double paidAmount,
                          String paymentMethod,
                          PaymentStatus status) {
        this.receiptId = generateReceiptId();
        this.billSummaryId = billSummaryId;
        this.paidAmount = paidAmount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.paymentDate = LocalDateTime.now();
    }

    private String generateReceiptId() {
        return "REC-" + UUID.randomUUID();
    }

    public String getReceiptId() {
        return receiptId;
    }

    public String getBillSummaryId() {
        return billSummaryId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
