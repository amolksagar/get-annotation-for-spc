package com.byo.springbootmicroservices.getannotationsforspc.domain.service.webservice.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.byo.springbootmicroservices.getannotationsforspc.constants.Constants;
import com.byo.springbootmicroservices.getannotationsforspc.domain.entity.Annotation;
import com.byo.springbootmicroservices.getannotationsforspc.domain.service.repository.AnnotationRepository;
import com.byo.springbootmicroservices.getannotationsforspc.exception.AnnotationNotFoundException;

@RestController
public class AnnotationRetriever {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment env;
	@Autowired
	private AnnotationRepository annotationRepository;

	@GetMapping("/retrieve-annotations-per-statisticalPrgCycleId/{spcId}")
	public ResponseEntity<List<Annotation>> retrieveAnnotationsPerStatisticalPrgCycleId(@PathVariable String spcId) {
		if (logger.isInfoEnabled())
			logger.info("Current Server Port is " + Integer.parseInt(env.getProperty("local.server.port")));
		Optional<List<Annotation>> annotations = Optional.ofNullable(annotationRepository.findBySpcId(spcId));
		if (annotations.isPresent()) {
			return ResponseEntity.ok(annotations.get());
		} else {
			throw new AnnotationNotFoundException(Constants.STR_ANNOTATION_NOT_FOUND_IN_DB);
		}
	}
}
