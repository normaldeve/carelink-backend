package com.normaldeve.carelinkbackend.tools;

import com.normaldeve.carelinkbackend.document.HospitalDocument;
import com.normaldeve.carelinkbackend.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * AI 챗봇이 사용할 도구들
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 31.
 */
@Component
@RequiredArgsConstructor
public class ChatbotTools {

    private final HospitalService hospitalService;

    @Tool(
            name = "findHospitals",
            description = "사용자 위치를 기반으로 근처 병원을 검색한다."
    )
    public List<HospitalDocument> findHospitals(
            @ToolParam(description = "위도") double lat,
            @ToolParam(description = "경도") double lon,
            @ToolParam(description = "거리") double distance
    ) {

        return hospitalService.findNearbyHospital(lat, lon, distance);
    }

}