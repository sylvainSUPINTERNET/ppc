package com.ppc.api.repository;

import java.util.List;

import com.ppc.api.entities.VisitorEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorEntityRepository extends CrudRepository<VisitorEntity, Long> {

    @Override
    List<VisitorEntity> findAll();
}