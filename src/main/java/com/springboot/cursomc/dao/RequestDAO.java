package com.springboot.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cursomc.entitys.Request;

@Repository
public interface RequestDAO extends JpaRepository<Request, Integer> {

}
