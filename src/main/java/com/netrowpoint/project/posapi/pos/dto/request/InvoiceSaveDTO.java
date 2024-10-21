package com.netrowpoint.project.posapi.pos.dto.request;

import com.netrowpoint.project.posapi.pos.entity.Customer;
import com.netrowpoint.project.posapi.pos.entity.InvoiceItems;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;
import java.util.Set;


public class InvoiceSaveDTO {

    private int customer;
    private Date date;

    private double total;
    private List<InvoiceItemSaveDTO> invoiceItems;

    public InvoiceSaveDTO() {
    }

    public InvoiceSaveDTO(int customer, Date date, double total) {
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

    public InvoiceSaveDTO(int customer, Date date, double total, List<InvoiceItemSaveDTO> invoiceItems) {
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.invoiceItems = invoiceItems;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<InvoiceItemSaveDTO> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItemSaveDTO> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
