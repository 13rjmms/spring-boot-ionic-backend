package com.springboot.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cursomc.entitys.City;

@Repository
public interface CityDAO extends JpaRepository<City, Integer> {

}
