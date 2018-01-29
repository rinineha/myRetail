package com.example.myRetail.services;

import com.example.myRetail.models.Product;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

@Service
public class ProductService {

    public Product getProductIdFromFile(String id) throws Exception {

        JSONParser parser = new JSONParser();
        Product result = new Product();

        try {
            Object jsonObject = parser.parse(new FileReader("C://Users/NMathur/myRedSky.json"));
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
}
