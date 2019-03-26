package com.byo.springbootmicroservices.getannotationsforspc.domain.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.byo.springbootmicroservices.getannotationsforspc.domain.entity.Annotation;

public interface AnnotationRepository extends JpaRepository<Annotation, Long> {
	List<Annotation> findBySpcId(String spcId);
}
