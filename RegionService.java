package com.example.RestApiDemo.service;

import com.example.RestApiDemo.entity.Region;
import com.example.RestApiDemo.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
    @Service
    public class RegionService
    {

        @Autowired
        private RegionRepository regionRepo;

        public String createRegion(String regionName)
        {
            Region region = new Region(regionName);
            regionRepo.save(region);
            return "Region created: " + regionName;
        }

        public Optional<Region> readRegion(int regionId)
        {
            return regionRepo.findById(regionId);
        }

        public String updateRegion(int regionId, String newName)
        {
            Optional<Region> regionOpt = regionRepo.findById(regionId);
            if (regionOpt.isPresent())
            {
                Region region = regionOpt.get();
                region.setRegionname(newName);
                regionRepo.save(region);
                return "Region updated: " + newName;
            } else
            {
                return "Region not found with ID: " + regionId;
            }
        }

        public String deleteRegion(int regionId)
        {
            if (regionRepo.existsById(regionId))
            {
                regionRepo.deleteById(regionId);
                return "Region deleted with ID: " + regionId;
            } else {
                return "Region not found with ID: " + regionId;
            }
        }
    }
