package com.netrowpoint.project.posapi.pos.service;

import com.netrowpoint.project.posapi.pos.dto.request.InvoiceSaveDTO;

public interface InvoiceService {
    public void saveInvoice(InvoiceSaveDTO invoiceSaveDTO);
}
