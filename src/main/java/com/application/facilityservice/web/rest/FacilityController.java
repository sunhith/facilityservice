package com.application.facilityservice.web.rest;

import com.application.facilityservice.domain.facilityEntity;
import com.application.facilityservice.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/facilities")
public class FacilityController {
    private final FacilityService facilityService;

    @Value("${facilityservice.title}")
    private String mess;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @RequestMapping(value = "/service/title", method = RequestMethod.GET)
    public String test(){
        return mess;
    }

    @GetMapping("/list")
    public List<facilityEntity> getAllFacilities() {
        return facilityService.getAllFacilities();
    }

    @GetMapping("/{facilityId}")
    public ResponseEntity<facilityEntity> getFacilityById(@PathVariable Long facilityId) {
        Optional<facilityEntity> facility = facilityService.getFacilityById(facilityId);
        return facility.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public facilityEntity createFacility(@RequestBody facilityEntity facility) {
        return facilityService.createFacility(facility);
    }

    @PutMapping("/{facilityId}")
    public ResponseEntity<facilityEntity> updateFacility(@PathVariable Long facilityId, @RequestBody facilityEntity updatedFacility) {
        Optional<facilityEntity> facility = facilityService.updateFacility(facilityId, updatedFacility);
        return facility.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{facilityId}")
    public ResponseEntity<Void> deleteFacility(@PathVariable Long facilityId) {
        boolean deleted = facilityService.deleteFacility(facilityId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
