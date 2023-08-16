package com.application.facilityservice.repository;

import com.application.facilityservice.domain.facilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<facilityEntity, Long> {
    // You can add custom query methods here if needed
}
