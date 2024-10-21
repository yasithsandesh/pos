package com.netrowpoint.project.posapi.pos.entity;

import com.netrowpoint.project.posapi.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "item")
@Data
public class Item {
    @Id
    @Column(name = "item_id",length = 45,nullable = true)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private int itemId;

    @Column(name = "item_name",length = 45,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_type",length = 100,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "qty",length = 100,nullable = false)
    private  double qty;

    @Column(name = "supplier_price",length = 100,nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price",length = 100,nullable = false)
    private double sellingPrice;

    @Column(name = "active_status",columnDefinition = "TINYINT default 0")
    private boolean activeStatus;

    @OneToMany(mappedBy="item")
    private Set<InvoiceItems> invoiceItems;



}
