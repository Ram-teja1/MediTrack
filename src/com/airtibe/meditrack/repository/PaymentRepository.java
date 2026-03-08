package com.airtibe.meditrack.repository;


import java.util.*;

import com.airtibe.meditrack.entity.PaymentReceipt;

public class PaymentRepository {

    private final Map<String, PaymentReceipt> receiptMap = new HashMap<>();

    public void save(PaymentReceipt receipt) {
        receiptMap.put(receipt.getReceiptId(), receipt);
    }

    public PaymentReceipt findById(String id) {
        return receiptMap.get(id);
    }

    public List<PaymentReceipt> findAll() {
        return new ArrayList<>(receiptMap.values());
    }

    public List<PaymentReceipt> findByBillSummaryId(String billSummaryId) {

        List<PaymentReceipt> result = new ArrayList<>();

        for (PaymentReceipt r : receiptMap.values()) {
            if (r.getBillSummaryId().equals(billSummaryId)) {
                result.add(r);
            }
        }

        return result;
    }
}
