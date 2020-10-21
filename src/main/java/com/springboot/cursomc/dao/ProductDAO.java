package com.springboot.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cursomc.entitys.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
