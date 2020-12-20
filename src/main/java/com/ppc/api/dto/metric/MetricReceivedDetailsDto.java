package com.ppc.api.dto.metric;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.stereotype.Service;

@Service
public class MetricReceivedDetailsDto {
    public String browserLanguage;
    public String browserPlatform;
    public String country;
    public String county;
    public String municipality;
    public String countryCode;
    public String postCode;
    public String state;
    public String town;

    public MetricReceivedDetailsDto(){}

    public MetricReceivedDetailsDto(String browserLanguage, String browserPlatform, String country, String county,
            String municipality, String postCode, String state, String town, String countryCode) {
        this.browserLanguage = browserLanguage;
        this.browserPlatform = browserPlatform;
        this.country = country;
        this.county = county;
        this.municipality = municipality;
        this.postCode = postCode;
        this.state = state;
        this.town = town;
        this.countryCode = countryCode;
    }


    public String getBrowserLanguage() {
        return this.browserLanguage;
    }

    public void setBrowserLanguage(String browserLanguage){
        this.browserLanguage = browserLanguage;
    }
    
    public String getBrowserPlatform () {
        return this.browserPlatform;
    }
    public void setBrowserPlatform (String browserPlatform) {
        this.browserPlatform = browserPlatform;
    }

    public String getCountry () {
        return this.country;
    }
    public void setCountry (String country) {
        this.country = country;
    }

    public String getCounty () {
        return this.county;
    }

    public void setCounty (String county) {
        this.county = county;
    }

    public String getMunicipality() {
        return this.municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postcode) {
        this.postCode = postcode;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
     this.town = town;
    }

    public String getCountryCode(){
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
}
