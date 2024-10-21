package com.netrowpoint.project.posapi.pos.dto.request;

import com.netrowpoint.project.posapi.pos.entity.enums.MeasuringUnitType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaveItemDTO {

    private String itemName;


    private MeasuringUnitType measuringUnitType;


    private  double qty;


    private double supplierPrice;


    private double sellingPrice;


}
