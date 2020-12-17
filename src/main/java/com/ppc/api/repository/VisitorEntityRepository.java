package com.ppc.api.repository;

import com.ppc.api.entities.VisitorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorEntityRepository extends JpaRepository<VisitorEntity, Long> {


}