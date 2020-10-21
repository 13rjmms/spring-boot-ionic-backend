package com.springboot.cursomc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cursomc.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

}
