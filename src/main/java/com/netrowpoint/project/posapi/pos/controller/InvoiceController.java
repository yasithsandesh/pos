package com.netrowpoint.project.posapi.pos.controller;

import com.netrowpoint.project.posapi.pos.dto.request.InvoiceSaveDTO;
import com.netrowpoint.project.posapi.pos.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
public class InvoiceController {
    @Autowired(required = true)
    private InvoiceService invoiceService;

    @PostMapping(path = "/save")
    public void saveOrder(@RequestBody InvoiceSaveDTO invoiceSaveDTO){
        invoiceService.saveInvoice(invoiceSaveDTO);
    }
}
