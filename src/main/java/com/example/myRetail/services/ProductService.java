package com.example.myRetail.services;

import com.example.myRetail.models.CurrentPrice;
import com.example.myRetail.models.Product;
import com.example.myRetail.repositories.CurrentPriceRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

@Service
public class ProductService {

    @Inject
    CurrentPriceRepository currentPriceRepository;

    public Product findByProductId(String id) throws Exception {
        Product result = new Product();
        result = getProductNameFromFile(id);
        return getProductPriceFromDatabase(result);
    }

    public Product updateProductPrice(Product product) throws Exception {
        return updateProductPriceToDatabase(product);
    }

    public Product getProductNameFromFile(String id) throws Exception {

        JSONParser parser = new JSONParser();
        Product result = new Product();

        try {
            Object jsonObject = parser.parse(new FileReader(ResourceUtils.getFile("classpath:files/myRedSky.json")));
            JSONObject fileObject = (JSONObject) jsonObject;
            JSONObject productObject = (JSONObject) fileObject.get("product");
            JSONObject itemObject = (JSONObject) productObject.get("item");

            if (itemObject.get("tcin").equals(id)) {
                JSONObject productDescription = (JSONObject) itemObject.get("product_description");
                result.setId(id);
                result.setName((String) productDescription.get("title"));

            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Product getProductPriceFromDatabase(Product product) throws Exception {
        if (null == product && StringUtils.isEmpty(product.getId())) {
            throw new Exception(" No pricing information found");
        }
        CurrentPrice currentPrice = currentPriceRepository.findByProductId(product.getId());
        product.setCurrentPrice(currentPrice);

        return product;
    }

    public Product updateProductPriceToDatabase(Product product) throws Exception {
        if (null == product && StringUtils.isEmpty(product.getId())) {
            throw new Exception("Cannot update product");
        }

        CurrentPrice currentPrice = currentPriceRepository.save(product.getCurrentPrice());
        product.setCurrentPrice(currentPrice);
        return product;
    }
}
