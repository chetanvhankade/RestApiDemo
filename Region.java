package com.example.RestApiDemo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "region_name")
    private String regionname;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Country> countries = new ArrayList<>();

    public Region()
    {

    }
    public Region(String regionname)
    {
        this.regionname=regionname;
    }
    public Integer getRegionId()
    {
        return regionId;
    }

    public void setRegionId(Integer regionId)
    {
        this.regionId = regionId;
    }
    public String getRegionname()
    {
        return regionname;
    }

    public void setRegionname(String regionname)
    {
        this.regionname=regionname;
    }
    public List<Country>getCountries()
    {
        return countries;
    }
    public void setCountries(List<Country> countries)
    {
        this.countries=countries;
    }
    public void addcountry(Country country)
    {
        countries.add(country);
        country.setRegion(this);
    }
}
