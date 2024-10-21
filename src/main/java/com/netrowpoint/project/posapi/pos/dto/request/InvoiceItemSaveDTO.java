package com.netrowpoint.project.posapi.pos.dto.request;

import com.netrowpoint.project.posapi.pos.entity.Invoice;
import com.netrowpoint.project.posapi.pos.entity.Item;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceItemSaveDTO {
    private int invoiceItemsId;
    private String itemName;

    private  double qty;
    private int invoice;

    private int item;
}
