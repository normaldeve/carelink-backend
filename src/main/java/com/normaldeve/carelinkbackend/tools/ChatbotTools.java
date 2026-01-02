package com.normaldeve.carelinkbackend.tools;

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

    @Tool(
            name = "findHospitals",
            description = "사용자 위치와 진료과를 기반으로 병원을 추천한다"
    )
    public List<String> findHospitals(
            @ToolParam(description = "위도") double lat,
            @ToolParam(description = "경도") double lon,
            @ToolParam(description = "진료과") String department
    ) {
        // 실제 병원 추천 로직
        return List.of("서울대병원", "강남세브란스");
    }

}