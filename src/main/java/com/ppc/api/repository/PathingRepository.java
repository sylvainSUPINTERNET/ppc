package com.ppc.api.repository;
 
import com.ppc.api.entities.Pathing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathingRepository extends CrudRepository<Pathing, Long> {

}