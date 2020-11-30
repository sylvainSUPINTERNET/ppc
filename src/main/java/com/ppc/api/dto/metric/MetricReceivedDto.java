package com.ppc.api.dto.metric;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetricReceivedDto {
    private String browserLanguage;
    private String browserPlatform;
    private String country;

    @JsonProperty("country_code")
    private String countryCode;
    private String county;
    private String municipality;

    private String postcode;

    private String state;
    private String town;

    MetricReceivedDto() {

    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBrowserPlatform() {
        return browserPlatform;
    }

    public void setBrowserPlatform(String browserPlatform) {
        this.browserPlatform = browserPlatform;
    }

    public String getBrowserLanguage() {
        return browserLanguage;
    }

    public void setBrowserLanguage(String browserLanguage) {
        this.browserLanguage = browserLanguage;
    }

    public MetricReceivedDto(String browserLanguage, String browserPlatform, String country, String countryCode,
            String county, String municipality, String postcode, String state, String town) {
        this.setBrowserLanguage(browserLanguage);
        this.setBrowserPlatform(browserPlatform);
        this.setCountry(country);
        this.setCountryCode(countryCode);
        this.setCounty(county);
        this.setMunicipality(municipality);
        this.setPostcode(postcode);
        this.setState(state);
        this.setTown(town);
    }
}