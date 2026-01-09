package com.normaldeve.carelinkbackend.controller;

import com.normaldeve.carelinkbackend.document.HospitalDocument;
import com.normaldeve.carelinkbackend.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/nearby")
    public List<HospitalDocument> nearby(
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam double km
    ) {
        return hospitalService.findNearbyHospital(lat, lng, km);
    }
}
