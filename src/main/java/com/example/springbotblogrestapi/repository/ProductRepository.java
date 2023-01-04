package com.example.springbotblogrestapi.repository;

import com.example.springbotblogrestapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT p from Product p where "+
            "p.name like concat('%', :query, '%')" +
            "Or p.description like concat('%', :query, '%')")
    List<Product> searchProducts(String query);

    @Query(value = "SELECT * from products p where "+
            "p.name like concat('%', :query, '%')" +
            "Or p.description like concat('%', :query, '%')", nativeQuery = true)
    List<Product> searchProductsSQL(String query);


}
