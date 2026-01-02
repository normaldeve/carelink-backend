package com.normaldeve.carelinkbackend.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 사용자 Document Class
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 31.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class UserDocument {

    @Id
    private Long id;

    private String phoneNumber;

    private String name;

    // 이전에 대화 여부 파악
    private int talkCount;

    // 특이 사항 (예: 겨울에는 항상 기관지가 안 좋음)
    private String memo;

}
