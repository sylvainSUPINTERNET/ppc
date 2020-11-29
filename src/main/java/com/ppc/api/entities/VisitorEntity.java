package com.ppc.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity(name="visitor")
public class VisitorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String browserLanguage;
    private String browserPlatform;
    private String country;
    private String countryCode;
    private String county;
    private String municipality;
    private String postcode;
    private String state;
    private String town;

    VisitorEntity(String browserLanguage, String browserPlatform, String country, String countryCode, String county,
            String municipality, String postcode, String state, String town) {

        this.browserLanguage = browserLanguage;
        this.browserPlatform = browserPlatform;
        this.country = country;
        this.countryCode = countryCode;
        this.county = county;
        this.municipality = municipality;
        this.postcode = postcode;
        this.state = state;
        this.town = town;
    }

    public String getBrowserLanguage() {
        return browserLanguage;
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

    public void setBrowserLanguage(String browserLanguage) {
        this.browserLanguage = browserLanguage;
    }

}
