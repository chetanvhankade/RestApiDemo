package com.example.RestApiDemo.repository;
import com.example.RestApiDemo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region ,Integer>
{
}
