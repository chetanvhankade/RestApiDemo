package com.example.RestApiDemo.service;

import com.example.RestApiDemo.entity.Country;
import com.example.RestApiDemo.entity.Region;
import com.example.RestApiDemo.repository.CountryRepository;
import com.example.RestApiDemo.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService
{
    @Autowired
    private CountryRepository countryRepo;

    @Autowired
    private RegionRepository regionRepo;

    public String createCountry(String countryId, String countryName, int regionId) {
        Optional<Region> regionOpt = regionRepo.findById(regionId);
        if (regionOpt.isPresent()) {
            Country country = new Country(countryId, countryName, regionOpt.get());
            countryRepo.save(country);
            return "Country created: " + countryName;
        } else {
            return "Region not found with ID: " + regionId;
        }
    }

    public Optional<Country> readCountry(String countryId) {
        return countryRepo.findById(countryId);
    }

    public String updateCountry(String countryId, String newName, int newRegionId) {
        Optional<Country> countryOpt = countryRepo.findById(countryId);
        Optional<Region> regionOpt = regionRepo.findById(newRegionId);
        if (countryOpt.isPresent() && regionOpt.isPresent()) {
            Country country = countryOpt.get();
            country.setCountryname(newName);
            country.setRegion(regionOpt.get());
            countryRepo.save(country);
            return "Country updated: " + newName;
        } else {
            return "Country or Region not found";
        }
    }

    public String deleteCountry(String countryId)
    {
        if (countryRepo.existsById(countryId))
        {
            countryRepo.deleteById(countryId);
            return "Country deleted with ID: " + countryId;
        } else {
            return "Country not found with ID: " + countryId;
        }
    }
}

