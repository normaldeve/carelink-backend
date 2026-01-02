package com.normaldeve.carelinkbackend.repository;

import com.normaldeve.carelinkbackend.document.HospitalDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
public interface HospitalRepository extends MongoRepository<HospitalDocument, String> {

}
