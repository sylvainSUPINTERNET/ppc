package com.ppc.api.services;

import com.ppc.api.dto.metric.MetricReceivedDetailsDto;
import com.ppc.api.dto.metric.MetricReceivedDto;
import com.ppc.api.repository.VisitorEntityRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.ppc.api.entities.VisitorEntity;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

@Service
public class VisitorEntityService {
    VisitorEntityRepository visitorEntityRepository;

    public VisitorEntityService(VisitorEntityRepository visitorEntityRepository) {
        this.visitorEntityRepository = visitorEntityRepository;
    };

    public Page<VisitorEntity> getVisitors(int page, int nbElements, String paramSort) {
        Pageable sortedByCreatedDate = PageRequest.of(page, nbElements, Sort.by(paramSort).descending()); // https://www.codeflow.site/fr/article/spring-data-jpa-pagination-sorting
        return this.visitorEntityRepository.findAll(sortedByCreatedDate);
    }

    public VisitorEntity createVisitorEntity(MetricReceivedDto metricReceivedDto, WebSocketSession session)
            throws IOException {

        VisitorEntity visitorEntity = new VisitorEntity();

        Gson gson = new Gson();
        String json = gson.toJson(metricReceivedDto.getData());
        MetricReceivedDetailsDto metricReceivedDetailsDto = gson.fromJson(json, MetricReceivedDetailsDto.class);
        
        visitorEntity.setBrowserLanguage(metricReceivedDetailsDto.getBrowserLanguage());
        visitorEntity.setBrowserPlatform(metricReceivedDetailsDto.getBrowserPlatform());
        visitorEntity.setCountry(metricReceivedDetailsDto.getCountry());
        visitorEntity.setCounty(metricReceivedDetailsDto.getCounty());
        visitorEntity.setCountryCode(metricReceivedDetailsDto.getCountryCode());
        visitorEntity.setMunicipality(metricReceivedDetailsDto.getMunicipality());
        visitorEntity.setPostcode(metricReceivedDetailsDto.getPostCode());
        visitorEntity.setState(metricReceivedDetailsDto.getState());
        visitorEntity.setTown(metricReceivedDetailsDto.getTown());
        this.visitorEntityRepository.save(visitorEntity);

        System.out.println("SAVED");
                // TODO create notifier here
        TextMessage msg = new TextMessage("[RESPONSE] - Vistor Created with success".getBytes());
        session.sendMessage(msg);

        return visitorEntity;
    }

    
}
