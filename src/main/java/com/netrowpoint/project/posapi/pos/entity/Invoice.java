package com.netrowpoint.project.posapi.pos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @Column(name = "invoice_id",length = 45,nullable = true)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private int invoiceId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "invoice_date",columnDefinition = "DATETIME")
    private Date date;


    @Column(name = "total",nullable = false)
    private double total;

    @OneToMany(mappedBy="invoice")
    private Set<InvoiceItems> invoiceItems;

    public Invoice() {
    }

    public Invoice(Customer customer, Date date, double total) {
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

    public Invoice(Customer customer, Date date, double total, Set<InvoiceItems> invoiceItems) {
        this.customer = customer;
        this.date = date;
        this.total = total;
        this.invoiceItems = invoiceItems;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public Set<InvoiceItems> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItems> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }
}
