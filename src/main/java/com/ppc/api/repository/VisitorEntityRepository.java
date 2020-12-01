package com.ppc.api.repository;
 
import com.ppc.api.entities.VisitorEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorEntityRepository extends CrudRepository<VisitorEntity, Long> {

}