package com.normaldeve.carelinkbackend.document;

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
 * 병원 Document Class
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 31.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "hospitals")
public class HospitalDocument {

    @Id
    private String id;

    private String hospitalId;

    private String name;

    private String address;

    private String phone;

    private String department;

    // 부가적인 설명 (점심시간, 외진 시간 등)
    private String etc1;

    private String etc2;

    // 병원 오는 길 안내
    private String info;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint location;

    // 요일별 시작/종료 (MON..SUN, HOLIDAY)
    private Map<String, String> startTime;

    private Map<String, String> closeTime;

    private LocalDateTime updatedAt;

}