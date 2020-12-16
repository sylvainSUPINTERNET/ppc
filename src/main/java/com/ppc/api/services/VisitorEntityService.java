package com.ppc.api.services;

import com.ppc.api.dto.metric.MetricReceivedDetailsDto;
import com.ppc.api.dto.metric.MetricReceivedDto;
import com.ppc.api.repository.VisitorEntityRepository;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.ppc.api.entities.VisitorEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


@Service
public class VisitorEntityService {
    VisitorEntityRepository visitorEntityRepository;

    public VisitorEntityService(VisitorEntityRepository visitorEntityRepository) {
        this.visitorEntityRepository = visitorEntityRepository;
    };



    public VisitorEntity createVisitorEntity (MetricReceivedDto metricReceivedDto) {

        VisitorEntity visitorEntity = new VisitorEntity();
        // TODO
        System.out.println("HERE");
        System.out.println(metricReceivedDto.getData());

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

        return visitorEntity;
    }

    
}
