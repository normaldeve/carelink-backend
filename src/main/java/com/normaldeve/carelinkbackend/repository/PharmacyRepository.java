package com.normaldeve.carelinkbackend.repository;

import com.normaldeve.carelinkbackend.domain.PharmacyDocument;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 약국 레포지토리
 *
 * @author junnukim1007gmail.com
 * @date 25. 12. 31.
 */
public interface PharmacyRepository extends MongoRepository<PharmacyDocument, String> {

    List<PharmacyDocument> findByLocationNear(Point point, Distance distance);

    List<PharmacyDocument> findByNameContaining(String name);
}

