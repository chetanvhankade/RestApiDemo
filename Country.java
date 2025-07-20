package com.example.RestApiDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="countries")
public class Country
{
    @Id
    @Column(name="country_id",length=2)
    private String countryid;
    @Column(name="country_name")
    private String countryname;

    @ManyToOne
    @JoinColumn(name="region_id",nullable = false)
    private Region region;

    public  Country()
    {
    }
    public Country(String countryid, String countryname, Region region)
    {
        this.countryid=countryid;
        this.countryname=countryname;
        this.region=region;
    }
    public String getCountryid()
    {
        return countryid;
    }

    public void setCountryid(String countryid)
    {
        this.countryid = countryid;
    }
    public String getCountryname()
    {
        return countryname;
    }

    public void setCountryname(String countryname)
    {
        this.countryname = countryname;
    }
    public Region getRegion()
    {
        return region;
    }
    public void setRegion(Region region)
    {
        this.region=region;
    }
}
