package com.airtibe.meditrack.interfaces;

import com.airtibe.meditrack.entity.BillSummary;
import com.airtibe.meditrack.entity.PaymentReceipt;

public interface Payable {

    PaymentReceipt pay(BillSummary billSummary);

}