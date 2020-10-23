package com.springboot.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cursomc.entitys.Package;

@Repository
public interface PackageDAO extends JpaRepository<Package, Integer> {

}
