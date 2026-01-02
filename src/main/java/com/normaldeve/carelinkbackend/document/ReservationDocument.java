package com.normaldeve.carelinkbackend.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 예약 Document Class
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 31.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "reservations")
public class ReservationDocument {

    @Id
    private String reservationId;

    private String hpid;

    private Long userId;

    private LocalDate reservationDate;

    private LocalTime reservationTime;

    private ReservationStatus status;

    // 부서
    private String department;

    private String symptom;

    private LocalDateTime createdAt;
}
