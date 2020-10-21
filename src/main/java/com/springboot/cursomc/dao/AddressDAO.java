package com.springboot.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cursomc.entitys.Address;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer> {

}
