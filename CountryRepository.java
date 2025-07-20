package com.example.RestApiDemo.repository;
import com.example.RestApiDemo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepository extends JpaRepository<Country,String>
{
}
