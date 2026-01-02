package com.normaldeve.carelinkbackend.service;

import com.normaldeve.carelinkbackend.document.HospitalDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
@Service
@RequiredArgsConstructor
public class HospitalService {

    private final MongoTemplate mongoTemplate;

    public List<HospitalDocument> findNearbyHospital(double latitude, double longitude, double distanceKm) {
        Point point = new Point(longitude, latitude);

        NearQuery nearQuery = NearQuery
                .near(point)
                .spherical(true)
                .maxDistance(new Distance(distanceKm, Metrics.KILOMETERS));

        GeoResults<HospitalDocument> results = mongoTemplate.geoNear(nearQuery, HospitalDocument.class);

        return results.getContent().stream()
                .map(GeoResult::getContent)
                .toList();
    }

}