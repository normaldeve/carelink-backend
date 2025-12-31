package com.normaldeve.carelinkbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 약국 Mongo DB Document
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 31.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "pharmacies")
public class PharmacyDocument {

    @Id
    private String id;

    private String pharmacyId;
    private String name;
    private String address;
    private String phone;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    // 요일별 시작/종료 (MON..SUN, HOLIDAY)
    private Map<String, String> startTime;
    private Map<String, String> closeTime;

    private LocalDateTime updatedAt;
}
