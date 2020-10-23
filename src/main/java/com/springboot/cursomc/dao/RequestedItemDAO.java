package com.springboot.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cursomc.entitys.RequestedItem;

@Repository
public interface RequestedItemDAO extends JpaRepository<RequestedItem, Integer> {

}
