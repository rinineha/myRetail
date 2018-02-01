package com.example.myRetail.repositories;

import com.example.myRetail.models.CurrentPrice;
import com.example.myRetail.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentPriceRepository extends MongoRepository<CurrentPrice, String>{
    public CurrentPrice findOneByProductId( String productId);

}
