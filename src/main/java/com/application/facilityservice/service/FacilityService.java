package com.application.facilityservice.service;

import com.application.facilityservice.domain.facilityEntity;
import com.application.facilityservice.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService {
    private final FacilityRepository facilityRepository;

    @Autowired
    public FacilityService(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    public List<facilityEntity> getAllFacilities() {
        return facilityRepository.findAll();
    }

    public Optional<facilityEntity> getFacilityById(Long facilityId) {
        return facilityRepository.findById(facilityId);
    }

    public facilityEntity createFacility(facilityEntity facility) {
        return facilityRepository.save(facility);
    }

    public Optional<facilityEntity> updateFacility(Long facilityId, facilityEntity updatedFacility) {
        if (facilityRepository.existsById(facilityId)) {
            updatedFacility.setFacilityId(facilityId);
            return Optional.of(facilityRepository.save(updatedFacility));
        }
        return Optional.empty();
    }

    public boolean deleteFacility(Long facilityId) {
        if (facilityRepository.existsById(facilityId)) {
            facilityRepository.deleteById(facilityId);
            return true;
        }
        return false;
    }
}
