package com.application.facilityservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "facility")
public class facilityEntity
{
    @Id
    @GeneratedValue
    private Long facilityId;

    private String facilityName;

    private String location;

    private String facilityType;

    public Long getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Long facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public String toString() {
        return "facilityEntity{" +
            "facilityId=" + facilityId +
            ", facilityName='" + facilityName + '\'' +
            ", location='" + location + '\'' +
            ", facilityType='" + facilityType + '\'' +
            '}';
    }
}
