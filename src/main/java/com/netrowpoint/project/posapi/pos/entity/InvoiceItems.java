package com.netrowpoint.project.posapi.pos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "invoice_items")
public class InvoiceItems {
    @Id
    @Column(name = "invoice_items_id",length = 45,nullable = true)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private int invoiceItemsId;

    @Column(name = "item_name",length = 45,nullable = false)
    private String itemName;

    @Column(name = "qty",length = 100,nullable = false)
    private  double qty;

    @ManyToOne
    @JoinColumn(name="invoice_id", nullable=false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    private Item item;

    public InvoiceItems() {
    }

    public InvoiceItems(String itemName, double qty, Invoice invoice, Item item) {
        this.itemName = itemName;
        this.qty = qty;
        this.invoice = invoice;
        this.item = item;
    }

    public int getInvoiceItemsId() {
        return invoiceItemsId;
    }

    public void setInvoiceItemsId(int invoiceItemsId) {
        this.invoiceItemsId = invoiceItemsId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
