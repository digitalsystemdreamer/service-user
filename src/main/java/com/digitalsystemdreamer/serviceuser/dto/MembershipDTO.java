package com.digitalsystemdreamer.serviceuser.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class MembershipDTO {

    private int membershipId;
    private String name;
    private String description;
    private LocalDate validFrom;
    private LocalDate validTo;
    private PackageDTO floorPackage;
    private Integer points;
    private List<FacilityDTO> facilities;
}
