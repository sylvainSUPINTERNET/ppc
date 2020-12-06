package com.ppc.api.services;

import com.ppc.api.dto.metric.MetricReceivedDto;
import com.ppc.api.repository.VisitorEntityRepository;

import org.springframework.stereotype.Service;
import com.ppc.api.entities.VisitorEntity;


@Service
public class VisitorEntityService {
    VisitorEntityRepository visitorEntityRepository;

    public VisitorEntityService(VisitorEntityRepository visitorEntityRepository) {
        this.visitorEntityRepository = visitorEntityRepository;
    };



    public VisitorEntity createVisitorEntity (MetricReceivedDto metricReceivedDto) {

        VisitorEntity visitorEntity = new VisitorEntity();
        /*
        visitorEntity.setBrowserLanguage(metricReceivedDto.getBrowserLanguage());
        visitorEntity.setBrowserPlatform(metricReceivedDto.getBrowserPlatform());
        visitorEntity.setCountry(metricReceivedDto.getCountry());
        visitorEntity.setCounty(metricReceivedDto.getCounty());
        visitorEntity.setCountryCode(metricReceivedDto.getCountryCode());
        visitorEntity.setMunicipality(metricReceivedDto.getMunicipality());
        visitorEntity.setPostcode(metricReceivedDto.getPostcode());
        visitorEntity.setState(metricReceivedDto.getState());
        visitorEntity.setTown(metricReceivedDto.getTown());*/

        this.visitorEntityRepository.save(visitorEntity);

        return visitorEntity;
    }

    
}
