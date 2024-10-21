package com.netrowpoint.project.posapi.pos.service.impl;

import com.netrowpoint.project.posapi.pos.dto.request.InvoiceItemSaveDTO;
import com.netrowpoint.project.posapi.pos.dto.request.InvoiceSaveDTO;
import com.netrowpoint.project.posapi.pos.entity.Invoice;
import com.netrowpoint.project.posapi.pos.entity.InvoiceItems;
import com.netrowpoint.project.posapi.pos.repo.CustomerRepo;
import com.netrowpoint.project.posapi.pos.repo.InvoiceItemRepo;
import com.netrowpoint.project.posapi.pos.repo.InvoiceRepo;
import com.netrowpoint.project.posapi.pos.repo.ItemRepo;
import com.netrowpoint.project.posapi.pos.service.InvoiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceIMPL implements InvoiceService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Autowired
    private InvoiceItemRepo invoiceItemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;


    @Override
    @Transactional
    public void saveInvoice(InvoiceSaveDTO invoiceSaveDTO) {

        Invoice newinvoice = new Invoice(
                customerRepo.getReferenceById(invoiceSaveDTO.getCustomer()),
                invoiceSaveDTO.getDate(),
                invoiceSaveDTO.getTotal()
        );

        invoiceRepo.save(newinvoice);

        if(invoiceRepo.existsById(newinvoice.getInvoiceId())){
            List<InvoiceItems> invoiceItemsList = new ArrayList<>();

            for(InvoiceItemSaveDTO invoiceItemSaveDTO : invoiceSaveDTO.getInvoiceItems()){
                InvoiceItems invoiceItem = new InvoiceItems(
                        invoiceItemSaveDTO.getItemName(),
                        invoiceItemSaveDTO.getQty(),
                        newinvoice,
                        itemRepo.getReferenceById(invoiceItemSaveDTO.getItem())

                );
                invoiceItemsList.add(invoiceItem);
            }

            invoiceItemRepo.saveAll(invoiceItemsList);

        }

    }
}
