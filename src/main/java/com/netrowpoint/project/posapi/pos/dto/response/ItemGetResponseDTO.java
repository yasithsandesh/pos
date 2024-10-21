package com.netrowpoint.project.posapi.pos.dto.response;

import com.netrowpoint.project.posapi.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.*;

public class ItemGetResponseDTO {

    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private  double qty;
    private double supplierPrice;
    private double sellingPrice;
    private boolean activeStatus;

    public ItemGetResponseDTO() {
    }

    public ItemGetResponseDTO(int itemId, String itemName, MeasuringUnitType measuringUnitType, double qty, double supplierPrice, double sellingPrice, boolean activeStatus) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.measuringUnitType = measuringUnitType;
        this.qty = qty;
        this.supplierPrice = supplierPrice;
        this.sellingPrice = sellingPrice;
        this.activeStatus = activeStatus;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public MeasuringUnitType getMeasuringUnitType() {
        return measuringUnitType;
    }

    public void setMeasuringUnitType(MeasuringUnitType measuringUnitType) {
        this.measuringUnitType = measuringUnitType;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}
